package com.example.halolampung;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PariwisataActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPariwisata;

    int[] IMAGES = {R.drawable.danau_ranau, R.drawable.lembah_hijau, R.drawable.pahawang, R.drawable.sari_ringgung, R.drawable.way_kambas};

    String[] NAMES =
            {"Danau Ranau",
            "Lembah Hijau",
            "Pahawang",
            "Sari Ringgung",
            "Way Kambas"};

    String [] DESC =
            {"Danau Ranau merupakan salah satu danau terbesar di Indonesia setelah Danau Toba. Letaknya berada di perbatasan Sumatra Selatan dan Lampung.",
            "Taman ini merupakan sebuah tempat rekreasi, waterboom dan juga ada kebun binatang mini." +
                    "Letak taman wisata lembah hijau ada di Tanjung Karang Barat, Lampung.",
            "Sebuah pulau dengan luas daratan sekitar 1.084 hektar dengan nama Pulau Pahawang. " +
                    "Tempat ini menjadi tempat wisata favorit wisatawan baik dari dalam negeri hingga luar negeri.",
            "Sari Ringgung mendapat respon baik dari wisatawan.Terdapat fenomena unik di tempat ini yaitu adanya pasir timbul saat air laut surut. " +
                    "Biasanya terjadi mendekati siang hari.",
            "Way Kambas merupakan taman suaka alam yang merupakan wisata di Lampung Timur. " +
                    "Memiliki 2 spot wisata yaitu Camp Jagawan Resort Way Kana dan Konservasi Gajah"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata);

        btnPariwisata = (Button) findViewById(R.id.button_prwst);
        btnPariwisata.setOnClickListener(this);

        ListView listView=(ListView)findViewById(R.id.list_pariwisata);

        CustomAdapter customAdapter= new CustomAdapter();

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ListParActivity.class);
                intent.putExtra("name",NAMES[i]);
                intent.putExtra("image",IMAGES[i]);
                startActivity(intent);
            }
        });

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.pariwisata_layout,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.imageView_par);
            TextView textView_name=(TextView)view.findViewById(R.id.textView_name);
            TextView textView_desc=(TextView)view.findViewById(R.id.textView_desc);

            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_desc.setText(DESC[i]);

            return view;
        }


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
