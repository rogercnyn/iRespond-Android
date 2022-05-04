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
        emailAdd = (EditText) findViewById(R.id.emailAdd);
        uName = (EditText) findViewById(R.id.uName);
        pass = (EditText) findViewById(R.id.password);
        rePass = (EditText) findViewById(R.id.retypePass);
        dbHandler = new DBHandler(RegForm3.this);
        next3 = (Button) findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getemailAdd = emailAdd.getText().toString();
                String getusername = uName.getText().toString();
                String getpass = pass.getText().toString();
                String getrepass = rePass.getText().toString();
                Intent intent1 = getIntent();
                String getfName = intent1.getStringExtra("fName");
                String getlName = intent1.getStringExtra("lName");

                if (getemailAdd.isEmpty() || getusername.isEmpty() || getpass.isEmpty() || getrepass.isEmpty()) {
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
                if (getrepass.isEmpty()){
                    rePass.getBackground().setTint(Color.RED);
                }
                if (!getrepass.isEmpty()){
                    rePass.getBackground().setTint(Color.WHITE);
                }

                if (!getemailAdd.isEmpty() || !getusername.isEmpty() || !getpass.isEmpty() || !getrepass.isEmpty()){
                    dbHandler.addThird(getemailAdd, getusername, getpass, getrepass, getfName, getlName);
                    Toast.makeText(RegForm3.this, "Account successfully registered!", Toast.LENGTH_SHORT).show();
                    openLogIn();
                    emailAdd.getText().clear();
                    uName.getText().clear();
                    pass.getText().clear();
                    rePass.getText().clear();
                }
            }

        });
    }
    public void openLogIn()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}