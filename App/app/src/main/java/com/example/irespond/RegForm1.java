package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegForm1 extends AppCompatActivity {
    private Button next1;
    public EditText fName, mName, lName, ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form1);
        fName = (EditText) findViewById(R.id.fName);
        mName = (EditText) findViewById(R.id.mName);
        lName = (EditText) findViewById(R.id.lName);
        ext = (EditText) findViewById(R.id.extension);

        next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getfName = fName.getText().toString();
                String getmName = mName.getText().toString();
                String getlName = lName.getText().toString();
                String getext = ext.getText().toString();

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
                    Intent intent = new Intent(RegForm1.this, RegForm2.class);
                    startActivity(intent);
                }
            }
        });
    }
}