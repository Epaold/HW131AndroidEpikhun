package com.example.hw131androidepikhun;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PressureRecording extends AppCompatActivity {
    private static  final  String TAG="MyApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure_recording);

        Date dateNow = new Date();
        SimpleDateFormat formdateNow = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        TextView textdate = findViewById(R.id.textView_dat_dat);
        textdate.setText(formdateNow.format(dateNow));

    }

    public void button_go(View view) {

        Log.i(TAG,"Переход к Жиз.параметры");
        Intent intent = new Intent(PressureRecording.this, LifeRecording.class);
        startActivity(intent);
    }

    public void button_back(View view) {
        Log.i(TAG,"Переход к Старт");
        Intent intent = new Intent(PressureRecording.this, MainActivity.class);
        startActivity(intent);
    }



    public void button_sv_press_rec(View view) {


        TextView texttime = findViewById(R.id.textView_dat_dat);
        String DTime = texttime.getText().toString();

        EditText textpressUp = findViewById(R.id.editTextNumber);
        String pressUp = textpressUp.getText().toString();

        EditText textpressd = findViewById(R.id.editTextNumber2);
        String pressdn = textpressd.getText().toString();

        EditText textpulse = findViewById(R.id.editTextNumber3);
        String pulse = textpulse.getText().toString();

        CheckBox chbx = findViewById(R.id.checkBox_thkd);
        boolean tahi = chbx.isChecked();

        if (DTime.equals("") || pressUp.equals("") || pressdn.equals("") || pulse.equals("")) {

            try {
                throw new NullPointerException("Заполнения требуют все ПОЛЯ");
            } catch (NullPointerException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        Log.i(TAG,"Сохраняем следующие данные: Дата и время замера - "+ DTime + " Верхнее дав. " + pressUp + " Нижнее дав. " + pressdn + " пульс " + pulse + " тахикардия " + tahi);
      /*  Toast.makeText(PressureRecording.this,   DTime + "ВВес"+ "   "+ pressUp +" "+ pulse + "  " + pressdn,Toast.LENGTH_LONG).show(); */

    }



}
