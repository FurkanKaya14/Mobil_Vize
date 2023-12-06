package com.example.vizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {

    Button sms_buton1;
    TextView sms_label1;
    TextView sms_label2;
    TextView sms_baslik;
    EditText sms_input1;
    EditText sms_input2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        sms_buton1 = findViewById(R.id.sms_buton1);
        sms_label1 = findViewById(R.id.sms_label1);
        sms_label2 = findViewById(R.id.sms_label2);
        sms_baslik = findViewById(R.id.sms_baslik);
        sms_input1 = findViewById(R.id.sms_input1);
        sms_input2 = findViewById(R.id.sms_input2);
        sms_buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MesajGonder();
            }
        });
    }
    private void MesajGonder(){
        String telNo = sms_input1.getText().toString();
        String Mesaj = sms_input2.getText().toString();
        if(telNo.isEmpty() || Mesaj.isEmpty()){
            return;
        }
        Uri uri = Uri.parse(("smsto:" + telNo));
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", Mesaj);
        startActivity(intent);
    }
}