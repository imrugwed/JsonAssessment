package com.example.jason2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String>name=new ArrayList<>();
    ArrayList<String>age= new ArrayList<>();
    ArrayList<String>salary= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {
            JSONObject jsonObject= new JSONObject(Objects.requireNonNull(loadJSONfromAssets()));
            JSONArray employees=jsonObject.getJSONArray("employees");
            for (int i = 0; i < employees.length(); i++) {
                JSONObject userDetail=employees.getJSONObject(i);
                name.add(userDetail.getString("name"));
                age.add(userDetail.getString("age"));
                salary.add(userDetail.getString("salary"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        try {
//            JSONObject obj = new JSONObject(loadJSONFromAsset());
//            JSONArray m_jArry = obj.getJSONArray("employees");
//            ArrayList<HashMap<String, String>> formList = new ArrayList<>();
//            HashMap<String, String> m_li = new HashMap<>();
//
//            for (int i = 0; i < m_jArry.length(); i++) {
//                JSONObject jo_inside = m_jArry.getJSONObject(i);
//                Log.d("Details-->", jo_inside.getString("name"));
//                String name = jo_inside.getString("name");
//                String age = jo_inside.getString("age");
//                String salary = jo_inside.getString("salary");
//
//
//                m_li.put("name", name);
//                m_li.put("age", age);
//                m_li.put("salary", salary);
//
//                formList.add(m_li);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        CustomAdapter customAdapter=new CustomAdapter(name,age,salary,MainActivity.this);
        recyclerView.setAdapter(customAdapter);
    }

//    public String loadJSONFromAsset() {
//        String json = null;
//        try {
//            InputStream is = getAssets().open("json.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//            is.read(buffer);
//            is.close();
//            json = new String(buffer, "UTF-8");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//        return json;
//    }

    @Nullable
    private String loadJSONfromAssets() {
        String json=null;
        try {
            InputStream is=getAssets().open("json.json");
            int size=is.available();

            byte[] buffer= new byte[size];
            is.read(buffer);
            is.close();

            json=new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
        return json;
    }
}