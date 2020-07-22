package com.example.hw131androidepikhun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {
private static  final  String TAG="MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init();
    }

    private void Init() {
        Button buttonsv = findViewById(R.id.button_sv);
        buttonsv.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
               Log.i(TAG,"Пользователь нажал на кнопку СОХРАНИТЬ");
                EditText textName = findViewById(R.id.editText_name);
                String name = textName.getText().toString();
                EditText textage = findViewById(R.id.editText_age);

                String age = textage.getText().toString();
                try {
                    int ageInt = Integer.parseInt(age);
                }
                catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Не правильный тип данных в поле ВОЗРАСТ или поле пустое",Toast.LENGTH_LONG).show();
                    Log.e(TAG,"Пользователь нажал на кнопку СОХРАНИТЬ",ex);
                }

                Log.i(TAG,"Сохраняем следующие данные: ФИО - "+ name + " Возраст " + age );
            }
        });

    }

   public void button_go(View view) {
        Intent intent = new Intent(MainActivity.this, PressureRecording.class);
        startActivity(intent);
    }

    public void button_back(View view) {
        Intent intent = new Intent(MainActivity.this, LifeRecording.class);
        startActivity(intent);
    }

}
