package com.example.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ListZamet extends AppCompatActivity {
    private SharedPreferences shp;
    private SharedPreferences.Editor shp_editor;
    private ArrayList<String> fruits;

    //определение
    private TextView lane ;
    private Button savebutton;
    private EditText editField ;
    private Button button223;

    private String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.list_zamet);

        //определение
        shp = getSharedPreferences("my_preferences",Context.MODE_PRIVATE);
        shp_editor = shp.edit();




        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //расшифровка распаковка
        String strMainArr=shp.getString("MainArr","");
        fruits = new ArrayList<>(Arrays.asList(strMainArr.split(",")));

//        определение и постановка
        lane = findViewById(R.id.textView);
        savebutton = findViewById(R.id.button);
        editField = findViewById(R.id.editTextText);
        button223=findViewById(R.id.button2);

        //получение данных с мейна
        Intent intent = getIntent();
        int poz = intent.getIntExtra("idpoz",42141);
        // вытаскиваем наше значение
        String item = fruits.get(poz);

        lane.setText("Заметкусы/"+item);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shp_editor.putString(item, editField.getText().toString());
                shp_editor.apply();
                Toast.makeText(getApplicationContext(),"Сохранено",Toast.LENGTH_SHORT).show();

            }
        });


        button223.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String itemData= shp.getString(item,"");
        editField.setText(itemData);


    }


    @Override
    protected void onPause(){
        if (item!= null && !item.isEmpty()){
        shp_editor.putString(item, editField.getText().toString());
        shp_editor.apply();}
        super.onPause();
    }





}
