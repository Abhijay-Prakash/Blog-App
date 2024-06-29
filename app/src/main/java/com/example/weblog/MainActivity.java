package com.example.weblog;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class MainActivity extends AppCompatActivity {

    EditText d1,d2;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SharedPreferences pref=getSharedPreferences("Blog",MODE_PRIVATE);
        String name=pref.getString("user",null);
        if(name!=null){
                Intent i=new Intent(getApplicationContext(), Blog.class);
                startActivity(i);
        }

        d1=(EditText) findViewById(R.id.ed1);
        d2=(EditText) findViewById(R.id.ed2);
        b1=(AppCompatButton) findViewById(R.id.bt1);
        b2=(AppCompatButton) findViewById(R.id.bt2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), SignUp.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String getUsername, getPass;
                    getUsername = d1.getText().toString();
                    getPass = d2.getText().toString();
                    if (getUsername.equals("admin") && getPass.equals("1234")) {
                        SharedPreferences pref=getSharedPreferences("Blog",MODE_PRIVATE);
                        SharedPreferences.Editor editor=pref.edit();
                        editor.putString("user","admin");
                        editor.apply();
                        Intent i = new Intent(getApplicationContext(), Blog.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.toString() + " ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}