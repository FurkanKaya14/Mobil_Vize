package com.example.vizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    private LinearLayout lineer2;
    private EditText random_input1;
    private EditText random_input2;
    private EditText random_input3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        lineer2 = findViewById(R.id.lineer2);
        random_input1 = findViewById(R.id.random_input1);
        random_input2 = findViewById(R.id.random_input2);
        random_input3 = findViewById(R.id.random_input3);
        Button random_buton1 = findViewById(R.id.random_buton1);
        random_buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OlusturButon();
            }
        });
    }
    private void OlusturButon(){
        String adet = random_input1.getText().toString();
        String min = random_input2.getText().toString();
        String max = random_input3.getText().toString();
        if(adet.isEmpty() || min.isEmpty() || max.isEmpty()){
            random_input1.setError("Lütfen bir sayı giriniz");
            return;
        }
        int istenenAdet = Integer.parseInt(adet);
        int minDeger = Integer.parseInt(min);
        int maxDeger = Integer.parseInt(max);
        int ekranGenisligi = getResources().getDisplayMetrics().widthPixels;
        Random random = new Random();
        lineer2.removeAllViews();
        for(int i = 0; i < istenenAdet; i++){
            ProgressBar progressBar;
            int baslangicdegeri, bitisDegeri, ilerlemeMiktari;
            do{
                baslangicdegeri = random.nextInt((maxDeger - minDeger) + 1) + minDeger;
                bitisDegeri = random.nextInt((maxDeger - baslangicdegeri) + 1) + baslangicdegeri;
                ilerlemeMiktari = random.nextInt((bitisDegeri - baslangicdegeri) + 1);
            } while (baslangicdegeri == bitisDegeri);
            progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            progressBar.setProgress(0);
            progressBar.setMax(bitisDegeri - baslangicdegeri);
            progressBar.setProgress(ilerlemeMiktari);
            TextView MinMaxLabel = new TextView(this);
            MinMaxLabel.setText("Min" + baslangicdegeri + "Max" + bitisDegeri);
            MinMaxLabel.setGravity(Gravity.CENTER);
            lineer2.addView(MinMaxLabel);
            TextView MinMaxLabel1 = new TextView(this);
            MinMaxLabel1.setText((ilerlemeMiktari + baslangicdegeri) + " (" + (double)(((double) ilerlemeMiktari / (double) (bitisDegeri - baslangicdegeri)) * 100 ) + "%)");
            MinMaxLabel1.setGravity(Gravity.CENTER);
            lineer2.addView(MinMaxLabel1);
            lineer2.addView(progressBar);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)
                    progressBar.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 16);
            layoutParams.gravity = Gravity.CENTER;
            progressBar.setLayoutParams(layoutParams);
        }
    }
}