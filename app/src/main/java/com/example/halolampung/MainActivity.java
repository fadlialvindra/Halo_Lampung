package com.example.halolampung;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnPariwisata;
    private Button btnKuliner;
    Button btn_fragment;
    final Context context = this;
    private Button button;
    private Spinner spNamen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPariwisata = (Button) findViewById(R.id.btn_pariwisata);
        btnPariwisata.setOnClickListener(this);
        btnKuliner = (Button) findViewById(R.id.btn_kuliner);
        btnKuliner.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pariwisata:
                Intent moveIntent = new Intent(MainActivity.this, PariwisataActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_kuliner:
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.layout_customdialog);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        //Toast.makeText(getApplicationContext(),"Dismissed..!!", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.pengembang) {
            startActivity(new Intent(this, DeveloperActivity.class));
        }
        if (item.getItemId() == R.id.tntng) {
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.fragment_about);
            Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
            // if button is clicked, close the custom dialog
            dialogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    //Toast.makeText(getApplicationContext(),"Dismissed..!!", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();
        }

        return true;
    }
}
