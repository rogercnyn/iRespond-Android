package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegForm3 extends AppCompatActivity {
    private Button next3;
    public EditText emailAdd, uName, pass, rePass;
    public EditText fName, mName, lName, ext;
    public EditText gender, age, bDay;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form3);
        fName = (EditText) findViewById(R.id.fName);
        mName = (EditText) findViewById(R.id.mName);
        lName = (EditText) findViewById(R.id.lName);
        ext = (EditText) findViewById(R.id.extension);
        gender = (EditText) findViewById(R.id.gender);
        age = (EditText) findViewById(R.id.age);
        bDay = (EditText) findViewById(R.id.bDay);
        emailAdd = (EditText) findViewById(R.id.emailAdd);
        uName = (EditText) findViewById(R.id.uName);
        pass = (EditText) findViewById(R.id.password);
        rePass = (EditText) findViewById(R.id.retypePass);
        dbHandler = new DBHandler(RegForm3.this);
        next3 = (Button) findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String getfName = fName.getText().toString();
                String getmName = mName.getText().toString();
                String getlName = lName.getText().toString();
                String getext = ext.getText().toString();
                String getgender = gender.getText().toString();
                String getage = age.getText().toString();
                String getbDay = bDay.getText().toString();*/
                String getemailAdd = emailAdd.getText().toString();
                String getusername = uName.getText().toString();
                String getpass = pass.getText().toString();
                String getrePass = rePass.getText().toString();

                if (getemailAdd.isEmpty() || getusername.isEmpty() || getpass.isEmpty() || getrePass.isEmpty()) {
                    Toast.makeText(RegForm3.this, "Please enter all of the required data.", Toast.LENGTH_SHORT).show();
                }

                if (getemailAdd.isEmpty()){
                    emailAdd.getBackground().setTint(Color.RED);
                }
                if (!getemailAdd.isEmpty()){
                    emailAdd.getBackground().setTint(Color.WHITE);
                }
                if (getusername.isEmpty()){
                    uName.getBackground().setTint(Color.RED);
                }
                if (!getusername.isEmpty()){
                    uName.getBackground().setTint(Color.WHITE);
                }
                if (getpass.isEmpty()){
                    pass.getBackground().setTint(Color.RED);
                }
                if (!getpass.isEmpty()){
                    pass.getBackground().setTint(Color.WHITE);
                }
                if (getrePass.isEmpty()){
                    rePass.getBackground().setTint(Color.RED);
                }
                if (!getrePass.isEmpty()){
                    rePass.getBackground().setTint(Color.WHITE);
                }

                /*dbHandler.addUser(getfName, getmName, getlName, getext, getgender, getage, getbDay, getemailAdd,
                            getusername, getpass, getrePass);*/
                Toast.makeText(RegForm3.this, "Account successfully registered!", Toast.LENGTH_SHORT).show();
                fName.getText().clear();
                mName.getText().clear();
                lName.getText().clear();
                ext.getText().clear();
                gender.getText().clear();
                age.getText().clear();
                bDay.getText().clear();
                emailAdd.getText().clear();
                uName.getText().clear();
                pass.getText().clear();
                rePass.getText().clear();
                Intent intent = new Intent(RegForm3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}