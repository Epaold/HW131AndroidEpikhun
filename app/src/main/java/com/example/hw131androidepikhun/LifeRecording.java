package com.example.hw131androidepikhun;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LifeRecording extends AppCompatActivity {
    private static  final  String TAG="MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_recording);
    }


    public void button_go(View view) {
        Log.i(TAG,"Переход к Старт");
        Intent intent = new Intent(LifeRecording.this, MainActivity.class);
        startActivity(intent);
    }

    public void button_back(View view) {

        Log.i(TAG,"Переход к Запись давления");

        Intent intent = new Intent(LifeRecording.this, PressureRecording.class);
        startActivity(intent);
    }


    public void button_sv_l_rec(View view) {

        EditText textVES = findViewById(R.id.editTextNumberDecimal);
        String VES = textVES.getText().toString();

        EditText textkolsh = findViewById(R.id.editText_kol_sh);
        String kolsh = textkolsh.getText().toString();

        if (VES.equals("") || kolsh.equals("")) {

            try {
                throw new NullPointerException("Заполнения требуют все ПОЛЯ");
            } catch (NullPointerException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        Log.i(TAG,"Сохраняем следующие данные: Вес - "+ VES + " Кол-во шагов " + kolsh );

       // Toast.makeText(LifeRecording.this, "ВВес"+ VES +" "+ kolsh,Toast.LENGTH_LONG).show();

    }


}
