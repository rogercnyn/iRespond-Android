package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegForm1 extends AppCompatActivity {
    private Button next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form1);

        next1 = (Button) findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegForm2();
            }
        });
    }
    public void openRegForm2()
    {
        Intent intent = new Intent(this, RegForm2.class);
        startActivity(intent);
    }
}