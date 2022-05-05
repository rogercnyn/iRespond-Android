package com.example.irespond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.irespond.R;

public class CreateStory extends AppCompatActivity {

    public Button postButton1;
    public TextView textUsername1;
    public EditText typeContent1;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_story);
        String toshowuname = getIntent().getStringExtra("showUsername");
        postButton1 = (Button) findViewById(R.id.postButton1);
        textUsername1 = (TextView) findViewById(R.id.textUsername1);
        typeContent1 = (EditText) findViewById(R.id.typeContent1);
        dbHelper = new DBHelper(CreateStory.this);
        textUsername1.setText(toshowuname);

        postButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = typeContent1.getText().toString();
                String username = textUsername1.getText().toString();
                if (content.isEmpty()){
                    Toast.makeText(CreateStory.this, "Input your story first.", Toast.LENGTH_LONG).show();
                }
                else{
                    dbHelper.addNewPost(username, content);
                    Toast.makeText(CreateStory.this, "Your story is now posted.", Toast.LENGTH_LONG).show();
                    typeContent1.getText().clear();
                    Intent intent = new Intent(CreateStory.this, Dashboard.class);
                    startActivity(intent);
                }

            }
        });
    }


}