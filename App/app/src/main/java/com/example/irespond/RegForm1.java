package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegForm1 extends AppCompatActivity  {
    private Button next1;
    public EditText fName, mName, lName, age, username, emailadd, password, repass;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reg_form1);
        fName = (EditText) findViewById(R.id.fName);
        mName = (EditText) findViewById(R.id.mName);
        lName = (EditText) findViewById(R.id.lName);
        age = (EditText) findViewById(R.id.age);
        username = (EditText) findViewById(R.id.username);
        emailadd = (EditText) findViewById(R.id.emailAdd);
        password = (EditText) findViewById(R.id.password);
        repass = (EditText) findViewById(R.id.confirmPass);
        dbHandler = new DBHandler(RegForm1.this);
        next1 = (Button) findViewById(R.id.register);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getfName = fName.getText().toString();
                String getmName = mName.getText().toString();
                String getlName = lName.getText().toString();
                String getage = age.getText().toString();
                String getusername = username.getText().toString();
                String getemailadd = emailadd.getText().toString();
                String getpass = password.getText().toString();
                String getrepass = repass.getText().toString();


                if (getfName.isEmpty() || getmName.isEmpty() || getlName.isEmpty()) {
                    Toast.makeText(RegForm1.this, "Please enter all of the required data.", Toast.LENGTH_SHORT).show();
                }

                if (getfName.isEmpty()){
                    fName.getBackground().setTint(Color.RED);
                }
                if (!getfName.isEmpty()){
                    fName.getBackground().setTint(Color.WHITE);
                }
                if (getmName.isEmpty()){
                    mName.getBackground().setTint(Color.RED);
                }
                if (!getmName.isEmpty()){
                    mName.getBackground().setTint(Color.WHITE);
                }
                if (getlName.isEmpty()){
                    lName.getBackground().setTint(Color.RED);
                }
                if (!getlName.isEmpty()){
                    lName.getBackground().setTint(Color.WHITE);
                }

                if (!getfName.isEmpty() || !getmName.isEmpty() || !getlName.isEmpty()){
                    dbHandler.addFirst(getfName, getmName, getlName, getage, getusername, getemailadd, getpass, getrepass);
                    Toast.makeText(RegForm1.this, "Account successfully registered!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegForm1.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}