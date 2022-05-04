package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        username = (EditText) findViewById(R.id.uName);
        emailadd = (EditText) findViewById(R.id.emailAdd);
        password = (EditText) findViewById(R.id.loginpassWord);
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
                    fName.setError("First name is required.");
                }
                if (getmName.isEmpty()){
                    mName.setError("Middle initial is required.");
                }
                if (getlName.isEmpty()){
                    lName.setError("Last name is required.");
                }
                if (getage.isEmpty()){
                    age.setError("Age is required.");
                }
                if (getusername.isEmpty()){
                    username.setError("Username is required.");
                }
                if (getemailadd.isEmpty()){
                    emailadd.setError("Email Address is required.");
                }
                if (getpass.isEmpty()){
                    password.setError("Password is required.");
                }
                if (getrepass.isEmpty()){
                    repass.setError("Retyping your password is required.");
                }
                if (!getpass.matches(getrepass)){
                    repass.setError("Your password does not match.");
                }

                else{
                    dbHandler.addFirst(getfName, getmName, getlName, getage, getusername, getemailadd, getpass, getrepass);
                    Toast.makeText(RegForm1.this, "Account successfully registered!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegForm1.this, MainActivity.class);
                    startActivity(intent);
                    fName.getText().clear();
                    mName.getText().clear();
                    lName.getText().clear();
                    age.getText().clear();
                    username.getText().clear();
                    emailadd.getText().clear();
                    password.getText().clear();
                    repass.getText().clear();
                }
            }
        });
    }
}