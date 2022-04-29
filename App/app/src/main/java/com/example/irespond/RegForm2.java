package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegForm2 extends AppCompatActivity {
    private Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form2);

        next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegForm3();
            }
        });
    }
    public void openRegForm3()
    {
        Intent intent = new Intent(this, RegForm3.class);
        startActivity(intent);
    }
}