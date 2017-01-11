package com.gdmec.jacky.mycontacts;

import android.content.ContentValues;
import android.content.Context;

public class ContactsTable {
    private final static String TABLENAME="contactsTable";
    private MyDB db;
    public ContactsTable(Context context){
        db=new MyDB(context);
        if (!db.isTableExits(TABLENAME)){
            String  createTableSql="create Table if not  exists"+TABLENAME+"(id_DB integer "
                    +"primary key autoincrement,"+
                    "User.NAME "+" VARCHAR,"+
                    "User.TEL "+" VARCHAR,"+
                    "User.UNIT "+" VARCHAR,"+
                    "User.QQ "+" VARCHAR,"+
                    "User.ADDRESS "+" VARCHAR)";
            db.creatTable(createTableSql);

        }
    }
    public boolean addData(User user){
        ContentValues values = new ContentValues();
        values.put(User.NANE,user.getName());
        values.put(User.TEL,user.getTel());
        values.put(User.UNIT,user.getUnit());
        values.put(User.QQ,user.getQq());
        values.put(User.ADDRESS,user.getAddress());
        return db.save(TABLENAME,values);
    }

}
