package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegForm2 extends AppCompatActivity {
    private Button next2;
    public EditText gender, age, bDay;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form2);

        gender = (EditText) findViewById(R.id.gender);
        age = (EditText) findViewById(R.id.age);
        bDay = (EditText) findViewById(R.id.bDay);
        dbHandler = new DBHandler(RegForm2.this);

        next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getgender = gender.getText().toString();
                String getage = age.getText().toString();
                String getbDay = bDay.getText().toString();
                Intent intent = getIntent();
                String getfName = intent.getStringExtra("fName");
                String getlName = intent.getStringExtra("lName");

                if (getgender.isEmpty() || getage.isEmpty() || getbDay.isEmpty()) {
                    Toast.makeText(RegForm2.this, "Please enter all of the required data.", Toast.LENGTH_SHORT).show();
                }

                if (getgender.isEmpty()){
                    gender.getBackground().setTint(Color.RED);
                }
                if (!getgender.isEmpty()){
                    gender.getBackground().setTint(Color.WHITE);
                }
                if (getage.isEmpty()){
                    age.getBackground().setTint(Color.RED);
                }
                if (!getage.isEmpty()){
                    age.getBackground().setTint(Color.WHITE);
                }
                if (getbDay.isEmpty()){
                    bDay.getBackground().setTint(Color.RED);
                }
                if (!getbDay.isEmpty()){
                    bDay.getBackground().setTint(Color.WHITE);
                }

                if (!getage.isEmpty() || !getgender.isEmpty() || !getbDay.isEmpty()){
                    dbHandler.addSecond(getgender, getage, getbDay, getfName, getlName);
                    Intent intent1 = new Intent(RegForm2.this, RegForm3.class);
                    intent1.putExtra("fName", getfName);
                    intent1.putExtra("lName", getlName);
                    startActivity(intent1);
                }
            }
        });
    }
}