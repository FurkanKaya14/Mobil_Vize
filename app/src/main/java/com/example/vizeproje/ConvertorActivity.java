package com.example.vizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

public class ConvertorActivity extends AppCompatActivity {
    TextView convertor_baslik;
    TextView convertor_label1;
    TextView convertor_label2;
    TextView convertor_label3;
    TextView convertor_label4;
    TextView convertor_label5;
    TextView convertor_label6;
    TextView convertor_label7;
    TextView convertor_label8;
    TextView convertor_label9;
    EditText convertor_input1;
    EditText convertor_input2;
    EditText convertor_input3;
    Spinner convertor_dropdown1;
    Spinner convertor_dropdown2;
    RadioGroup convertor_grup;
    RadioButton convertor_radio1;
    RadioButton convertor_radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);
        convertor_baslik = findViewById(R.id.convertor_baslik);
        convertor_label1 = findViewById(R.id.convertor_label1);
        convertor_label2 = findViewById(R.id.convertor_label2);
        convertor_label3 = findViewById(R.id.convertor_label3);
        convertor_label4 = findViewById(R.id.convertor_label4);
        convertor_label5 = findViewById(R.id.convertor_label5);
        convertor_label6 = findViewById(R.id.convertor_label6);
        convertor_label7 = findViewById(R.id.convertor_label7);
        convertor_label8 = findViewById(R.id.convertor_label8);
        convertor_label9 = findViewById(R.id.convertor_label9);
        convertor_input1 = findViewById(R.id.convertor_input1);
        convertor_input2 = findViewById(R.id.convertor_input2);
        convertor_input3 = findViewById(R.id.convertor_input3);
        convertor_dropdown1 = findViewById(R.id.convertor_dropdown1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Decimal,
                android.R.layout.simple_spinner_item);
        convertor_dropdown1.setAdapter(adapter);
        convertor_dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                decimalDonusum();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                convertor_input1.setError("Lütfen bir değer seçin");
            }
        });
        convertor_dropdown2 = findViewById(R.id.convertor_dropdown2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Byte,
                android.R.layout.simple_spinner_item);
        convertor_dropdown2.setAdapter(adapter1);
        convertor_dropdown2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                byteDonusum();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                convertor_input2.setError("Lütfen bir değer seçin");
            }
        });

                convertor_grup = findViewById(R.id.convertor_grup);
                convertor_radio1 = findViewById(R.id.convertor_radio1);
                convertor_radio2 = findViewById(R.id.convertor_radio2);
                convertor_radio1.setChecked(false);
                convertor_radio2.setChecked(false);
                convertor_grup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        celciusDonusum();
                    }
                });
    }
    private void decimalDonusum(){
        String input1 = convertor_input1.getText().toString().trim();
        if(TextUtils.isEmpty(input1)){
            convertor_input1.setError("Lütfen bir sayı giriniz!");
            return;
        }
        double girilenDeger = Double.parseDouble(input1);
        String donusumTuru = convertor_dropdown1.getSelectedItem().toString();
        String sonuc = "";
        switch (donusumTuru){
            case "İkilik":
            sonuc = Integer.toBinaryString((int)girilenDeger);
            break;
            case "Sekizlik":
            sonuc = Integer.toOctalString((int)girilenDeger);
            break;
            case "On Altılık":
            sonuc = Integer.toHexString((int)girilenDeger);
            break;
        }
        convertor_input1.setError(null);
        convertor_label7.setText(sonuc);
    }
    private void byteDonusum(){
        String input2 = convertor_input2.getText().toString().trim();
        if(TextUtils.isEmpty(input2)){
            convertor_input2.setError("Lütfen bir sayı giriniz!");
            return;
        }
        double girilenDeger2 = Double.parseDouble(input2);
        String donusumTuru1 = convertor_dropdown2.getSelectedItem().toString();
        String sonuc1 = "";
        switch (donusumTuru1){
            case "Kilo byte":
                sonuc1 = String.valueOf(girilenDeger2 * 1024);
                break;
            case "Byte":
                sonuc1 = String.valueOf(girilenDeger2 * 1024 * 1024);
                break;
            case "Kibi byte":
                sonuc1 = String.valueOf(girilenDeger2 * 1024 / 1000);
                break;
            case "Bit":
                sonuc1 = String.valueOf(girilenDeger2 * 1024 * 1024 * 8);
                break;
        }
        convertor_input2.setError(null);
        convertor_label8.setText(sonuc1);
    }
    private void celciusDonusum(){
        String input3 = convertor_input3.getText().toString().trim();
        if(TextUtils.isEmpty(input3)){
            convertor_input3.setError("Lütfen bir sayı giriniz!");
            return;
        }
        double girilenDeger3 = Double.parseDouble(input3);
        String sonuc2 = "";
        if(convertor_radio1.isChecked()){
            sonuc2 = String.valueOf((girilenDeger3 * 9 / 5) + 32);
        } else if (convertor_radio2.isChecked()) {
            sonuc2 = String.valueOf(girilenDeger3 + 273.15);
        }
        convertor_input3.setError(null);
        convertor_label9.setText(sonuc2);
    }
}