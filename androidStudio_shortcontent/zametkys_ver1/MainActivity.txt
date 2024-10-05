package com.example.myfirstapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences shp;
    private SharedPreferences.Editor shp_editor;
    private ArrayList<String> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        ArrayList<String> fruits = new ArrayList<>();
//        fruits.add("Выполнил");
//        fruits.add("Не выполнил");
//        fruits.add("0");
//        int[] t={0};
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,R.layout.custom_list_item, fruits);
//        ListView lvMain = (ListView)findViewById(R.id.listView);
//        lvMain.setAdapter(adapter1);
//        lvMain.setOnItemClickListener((parent, view, position, id) ->{
//            if (position==0){
//                t[0]++;
//            fruits.set(2,"Суммарно выполнено : "+String.valueOf(t[0]));
//            adapter1.notifyDataSetChanged();}
//            if (position==1){
//                t[0]--;
//                fruits.set(2,"Суммарно выполнено : "+String.valueOf(t[0]));
//                adapter1.notifyDataSetChanged();}
//
//        });


//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.custom_list_item, fruits);
//        android.R.layout.custom_list_item_1

//        ArrayList<String> fruits = new ArrayList<>();
//        fruits.add("Понравилось");
//        fruits.add("не понравилось");
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,R.layout.custom_list_item, fruits);
//        ListView lvMain = (ListView)findViewById(R.id.listView);
//        lvMain.setAdapter(adapter1);
//
//        lvMain.setOnItemClickListener((parent, view, position, id) ->{
//            String selectedFruit = fruits.get(position);         // ЭТО ПОДСВЕТИТЬ
//            Toast.makeText(this,selectedFruit,Toast.LENGTH_SHORT).show();
//        });

//        ЭТО МОЙ ЛЮБИМЫЙ СЧЕТЧИК)))))

         shp = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
         shp_editor = shp.edit();

        String strMainArr=shp.getString("MainArr","");
        fruits = new ArrayList<>(Arrays.asList(strMainArr.split(",")));

        int mainLen = fruits.toArray().length;
        if (strMainArr.isEmpty()){
            fruits.remove(0);
        fruits.add("Добавить");
        fruits.add("Удалить");
        }

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.cm_ann_kill_holy_02);  // Путь к mp4 файлу (звуковому файлу) указывается через R.raw.sound_file
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,R.layout.custom_list_item, fruits);

        ListView lvMain = (ListView)findViewById(R.id.listView);
        lvMain.setAdapter(adapter1);
        lvMain.setOnItemClickListener((parent, view, position, id) ->{
            if (position==0)
            {
            int randomInt = (int) (Math.random() * Integer.MAX_VALUE);
            fruits.add(String.valueOf(randomInt));
            mediaPlayer.start(); // Воспроизведение звукового файла
            adapter1.notifyDataSetChanged();



            }
            if (position==1)
            {
                int poz = fruits.size();
                    if(poz>=3)
                    {
                        fruits.remove(poz - 1);
                        adapter1.notifyDataSetChanged();
                    }
            }
            else
            { try {
                openCurList(position);
            }catch (Exception e){
                createCurList(position);
            }

            }
                                                                    });



    }

    protected void openCurList(int a){


    }
    protected void createCurList(int a){

    }


    @Override
    protected void onPause(){

        String fruitsStr = TextUtils.join(",", fruits);
        shp_editor.putString("MainArr", fruitsStr);
        shp_editor.apply();
        super.onPause();
    }
}