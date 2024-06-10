package com.example.myfirstapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
    private String userInput;

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

            if (position==0) {
                //int randomInt = (int) (Math.random() * Integer.MAX_VALUE);
                //fruits.add(String.valueOf(randomInt));

//                тут надо вызывать окно с едит текст для получения имени заметки
                //openNamedialog();

//                fruits.add(userInput);

//            mediaPlayer.start(); // Воспроизведение звукового файла
//            adapter1.notifyDataSetChanged();

//начинаем вертилово
//===============================================================================================
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Введите информацию");

        // Установка поля для ввода текста
                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                // кнопка "Продолжить"
//                builder.setPositiveButton("Продолжить",null);

                builder.setPositiveButton("Продолжить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userInput = input.getText().toString();
                        if(!(userInput.isEmpty()))
                        {
                            fruits.add(userInput);
                            mediaPlayer.start(); // Воспроизведение звукового файла
                        }
                        else {Toast.makeText(getApplicationContext(),"ты долабеб нихуя не ввел",Toast.LENGTH_SHORT).show();}
                        adapter1.notifyDataSetChanged();

                    }
                });

                //кнопка рандомио цифро
                builder.setNeutralButton("пох сам сделать tab", null);

                //  кнопка "Отмена"
                builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel(); // Закрыть диалоговое окно
                    }
                });

                // Показ диалогового окна
                AlertDialog dialog = builder.create();
                ///
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int randomInt = (int) (Math.random() * Integer.MAX_VALUE);
                                input.append(String.valueOf(randomInt));
                            }
                        });
//                        Button button1 = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
//                        button1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                if (userInput.isEmpty()){
//                                    Toast.makeText(getApplicationContext(),"ты не ввел",Toast.LENGTH_SHORT).show();
//                                }
//                                else {
//                                    fruits.add(userInput);
//                                    mediaPlayer.start(); // Воспроизведение звукового файла
//                                    adapter1.notifyDataSetChanged();
//                                    dialog.cancel();
//                                }
//                            }
//                        });
                    }
                });
                ///
                dialog.show();
//===============================================================================================
//Заканчиваем вертилово


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
            {
                try
                {
                    openCurList(position);
                }catch (Exception e)
                {
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