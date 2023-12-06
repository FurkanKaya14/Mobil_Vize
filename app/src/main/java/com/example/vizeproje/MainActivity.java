package com.example.vizeproje;



import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

Button giris_buton1;
Button giris_buton2;
Button giris_buton3;
TextView giris_isim;
TextView giris_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        giris_buton1 = findViewById(R.id.giris_buton1);
        giris_buton2 = findViewById(R.id.giris_buton2);
        giris_buton3 = findViewById(R.id.giris_buton3);
        giris_isim = findViewById(R.id.giris_isim);
        giris_no = findViewById(R.id.giris_no);
        giris_buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ConvertorActivity.class);
                startActivity(i);
            }
        });
        giris_buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(i);
            }
        });
        giris_buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RandomActivity.class);
                startActivity(i);
            }
        });
    }

}