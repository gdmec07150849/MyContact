package com.gdmec.jacky.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MyDB extends SQLiteOpenHelper{
    private static String DB_NAME="My_DB.db";
    private static int DB_VRESION=2;
    private SQLiteDatabase db;
    public MyDB(Context context){
        super(context,DB_NAME,null,DB_VRESION);
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public SQLiteDatabase openConnection(){
        db=getWritableDatabase();
        return db;
    }
    public void  closeConnection(){
        try {
         if (db!=null&&db.isOpen()){
        db.close();
        }
        }catch (Exception e){
        e.printStackTrace();
        }

    }
    public boolean creatTable(String creatTableSql){
        try {
            openConnection();
            db.execSQL(creatTableSql);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
    public boolean save(String tablename, ContentValues values){
        try {
            openConnection();
            db.insert(tablename,null,values);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
    public boolean update(String table,ContentValues values,String whereClause,String []whereArgs){
        try {
            openConnection();
            db.update(table,values,whereClause,whereArgs);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;

    }
    public boolean delete(String table,String deleteSql,String obj[]){
        try {
            openConnection();
            db.delete(table,deleteSql,obj);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;
    }
    public Cursor find(String findSql,String obj[]){
        try {
            openConnection();
            Cursor cursor=db.rawQuery(findSql,obj);
            return cursor;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return null;
    }
    public boolean isTableExits(String tablename){
        try {
            openConnection();
            String str="select count(*)xcont from "+tablename;
            db.rawQuery(str,null).close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            closeConnection();
        }
        return true;

    }
}
