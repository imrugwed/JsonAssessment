package com.example.jason2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<String> name;
    ArrayList<String>age;
    ArrayList<String>salary;
    Context ctx;

    public CustomAdapter(ArrayList<String> name, ArrayList<String> age,ArrayList<String> salary,Context ctx){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.ctx=ctx;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        holder.name.setText(name.get(position));
        holder.age.setText(age.get(position));
        holder.salary.setText(salary.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ctx, name.get(position)+" "+age.get(position)+" "+salary.get(position), Toast.LENGTH_SHORT).show();
                String str = name.get(position);
                String str1 = age.get(position);
                String str2 = salary.get(position);
                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(ctx, MainActivity2.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("name", str);
                intent.putExtra("age", str1);
                intent.putExtra("salary", str2);
                // start the Intent
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,age,salary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
            salary=itemView.findViewById(R.id.salary);
        }
    }
}
