package com.example.weblog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Add extends AppCompatActivity {

    EditText d1,d2;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        d1=(EditText) findViewById(R.id.ed1);
        d2=(EditText) findViewById(R.id.ed2);
        b1=(AppCompatButton) findViewById(R.id.bt1);
        b2=(AppCompatButton) findViewById(R.id.bt2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String s1,s2;
                    s1=d1.getText().toString();
                    s2=d2.getText().toString();
                    Toast.makeText(getApplicationContext(),s1+s2+ " ", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),e.toString() + " ", Toast.LENGTH_SHORT).show();
                }

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), Blog.class);
                startActivity(i);
            }
        });

    }
}