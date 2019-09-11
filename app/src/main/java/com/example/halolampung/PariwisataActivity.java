package com.example.halolampung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PariwisataActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPariwisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata);
        btnPariwisata = (Button) findViewById(R.id.button_prwst);
        btnPariwisata.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_prwst:
                Intent moveIntent = new Intent(PariwisataActivity.this, CekHarga.class);
                startActivity(moveIntent);
                break;

        }
    }
}
