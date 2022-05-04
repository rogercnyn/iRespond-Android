package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button login,register;
    private EditText uname, pword;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = findViewById(R.id.loginuName);
        pword = findViewById(R.id.loginpassWord);
        dbHandler = new DBHandler(MainActivity.this);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = uname.getText().toString();
                String passw = pword.getText().toString();
                boolean checkaccount = dbHandler.checkaccount(user, passw);
                if (user.isEmpty()){
                    uname.setError("Username is required.");
                }
                if (passw.isEmpty()){
                    pword.setError("Password is required.");
                }
                if (checkaccount == true) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    intent.putExtra("keyusername", user);
                    startActivity(intent);
                    uname.getText().clear();
                    pword.getText().clear();
                }
                if (user.isEmpty() || passw.isEmpty()){
                    Toast.makeText(MainActivity.this, "Input your username and password.",Toast.LENGTH_SHORT).show();

                }
                if (checkaccount == false){
                    uname.getText().clear();
                    pword.getText().clear();
                    Toast.makeText(MainActivity.this, "Wrong username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegForm1();
            }
        });
    }

    public void openRegForm1()
    {
        Intent intent = new Intent(this, RegForm1.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}