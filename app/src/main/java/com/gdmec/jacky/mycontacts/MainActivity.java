package com.gdmec.jacky.mycontacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText telEditText;
    private EditText unitEditText;
    private EditText qqEditText;
    private EditText addressEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("添加联系人");
        nameEditText= (EditText) findViewById(R.id.name);
        telEditText= (EditText) findViewById(R.id.tel);
        unitEditText= (EditText) findViewById(R.id.unit);
        qqEditText= (EditText) findViewById(R.id.qq);
        addressEditText= (EditText) findViewById(R.id.address);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(Menu.NONE,1, Menu.NONE,"保存");
        menu.add(Menu.NONE,2, Menu.NONE,"返回");
    return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:if (!nameEditText.getText().toString().equals("")) {
                User user = new User();
                user.setName(nameEditText.getText().toString());
                user.setTel(telEditText.getText().toString());
                user.setUnit(unitEditText.getText().toString());
                user.setQq(qqEditText.getText().toString());
                user.setAddress(addressEditText.getText().toString());
                ContactsTable ct = new ContactsTable(this);
                if (ct.addData(user)) {
                    Toast.makeText(MainActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "添加失败！", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(MainActivity.this, "请先输入数据！", Toast.LENGTH_SHORT).show();
            } break;
        }


        return super.onOptionsItemSelected(item);
    }
}
