package com.example.halolampung;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CekHarga extends AppCompatActivity implements View.OnClickListener {
    public  int harga = 0;
    private Spinner spNamen2;
    private EditText jml_orang;
    private TextView hasil;
    private Button hitung_harga;
    private String[] germanFeminine = {
            "Pahawang",
            "Danau Ranau"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata);
        setContentView(R.layout.activity_cek_harga);
        jml_orang = (EditText)findViewById(R.id.jml_orang);
        hitung_harga = (Button)findViewById(R.id.hitung_harga);
        hasil = (TextView)findViewById(R.id.hasil_hitung_harga);
        hitung_harga.setOnClickListener(this);

        spNamen2 = (Spinner) findViewById(R.id.sp_name_2);

        // inisialiasi Array Adapter dengan memasukkan string array di atas
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, germanFeminine);

        // mengeset Array Adapter tersebut ke Spinner
        spNamen2.setAdapter(adapter);

        // mengeset listener untuk mengetahui saat item dipilih
        spNamen2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // memunculkan toast + value Spinner yang dipilih (diambil dari adapter)
                String destinasi = adapter.getItem(i);
                if(destinasi=="Pahawang"){
                    harga = 30000;
                }
                else if(destinasi=="Danau Ranau"){
                    harga = 20000;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hitung_harga){
            String jmlorang = jml_orang.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(jmlorang)){
                isEmptyFields = true;
                jml_orang.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                int jml = Integer.parseInt(jmlorang);
                int total = jml*harga;
                hasil.setText(String.valueOf(total));
            }
        }
    }

}
