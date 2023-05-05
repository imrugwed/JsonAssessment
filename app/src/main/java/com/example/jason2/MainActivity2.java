package com.example.jason2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView name,age,salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        salary = findViewById(R.id.salary);
        // create the get Intent object
        Intent intent = getIntent();
        // receive the value by getStringExtra() method and
        // key must be same which is send by first activity
        String str = intent.getStringExtra("name");
        String str1 = intent.getStringExtra("age");
        String str2 = intent.getStringExtra("salary");
        // display the string into textView
        name.setText(str);
        age.setText(str1);
        salary.setText(str2);
    }
}