package com.example.weblog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Blog extends AppCompatActivity {
    AppCompatButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blog);

        b1=(AppCompatButton) findViewById(R.id.bt1);
        b2=(AppCompatButton) findViewById(R.id.bt2);
        b3=(AppCompatButton) findViewById(R.id.bt3);
        b4=(AppCompatButton) findViewById(R.id.bt4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Add.class);
                startActivity(i);
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Delete.class);
                startActivity(i);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Search.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getSharedPreferences("Blog",MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}