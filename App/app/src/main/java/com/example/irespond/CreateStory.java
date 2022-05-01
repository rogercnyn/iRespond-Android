package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.irespond.R;

public class CreateStory extends AppCompatActivity {

    public Button postStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story);

        postStory = findViewById(R.id.postStory);
        postStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateStory.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }


}