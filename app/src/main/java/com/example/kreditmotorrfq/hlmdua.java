package com.example.kreditmotorrfq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class hlmdua extends AppCompatActivity {

    //deklarasi id
    Integer id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlmdua);

        getIncomingIntent();

        setData(id);
    }
    private void getIncomingIntent(){
        if (getIntent().hasExtra("id")) {
            id = Integer.parseInt(getIntent().getStringExtra("id"));
            Log.i("id", String.valueOf(id));
        }
    }

    private void setMotor(TextView tvnama, String nama, TextView tvharga, String harga, ImageView gambar, Integer db, LinearLayout lla){
        tvnama.setText(nama);
        tvharga.setText(harga);
        gambar.setImageResource(db);
        lla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hlmdua.this, hlmtiga.class);
                intent.putExtra("nama", nama);
                intent.putExtra("harga", harga);
                intent.putExtra("gambar", db);
                startActivity(intent);
            }
        });
    }

    private void setData(Integer id){
        LinearLayout [] ll      = {findViewById(R.id.kartu1) , findViewById(R.id.kartu2), findViewById(R.id.kartu3),
                                   findViewById(R.id.kartu4), findViewById(R.id.kartu5), findViewById(R.id.kartu6)};

        TextView [] tvnama      = {findViewById(R.id.nama1), findViewById(R.id.nama2), findViewById(R.id.nama3),
                                   findViewById(R.id.nama4), findViewById(R.id.nama5), findViewById(R.id.nama6)};

        TextView [] tvharga     = {findViewById(R.id.harga1), findViewById(R.id.harga2), findViewById(R.id.harga3),
                                   findViewById(R.id.harga4), findViewById(R.id.harga5), findViewById(R.id.harga6)};

        ImageView [] ivgambar   = {findViewById(R.id.gambar1), findViewById(R.id.gambar2), findViewById(R.id.gambar3),
                                   findViewById(R.id.gambar4), findViewById(R.id.gambar5), findViewById(R.id.gambar6)};

        TextView tvMerk = findViewById(R.id.namamerk);


        if (id == 1) {

            tvMerk.setText("Motor Honda");
            String [] nama      = {"Beat CBS ISS", "CB 150 SR", "CB 150 VERZA", "Beat Street", "Honda Genio", "Super Cub 125"};
            String [] harga     = {"Rp. 20.880.000","Rp. 32.400.000","Rp. 22.920.000", "Rp. 20.000.000", "Rp. 21.000.000", "Rp. 78.000.000"};
            Integer [] gambar   = {R.drawable.hdbeatcbsiss, R.drawable.hdcb150sr, R.drawable.hdcb150verza, R.drawable.hdbeatstreet, R.drawable.hdgenio, R.drawable.hdsupercub};

            for (int i = 0; i < nama.length; i++) {
                setMotor(tvnama[i], nama[i], tvharga[i], harga[i], ivgambar[i], gambar[i], ll[i]);
            }
        }

        else if (id == 3) {

            tvMerk.setText("Motor Suzuki");
            String[] nama       = {"Address F1", "GIXER SF", "GSX-R150", "CB 150 VERZA", "NEX II", "Satria F150"};
            String[] harga      = {"Rp. 21.890.000", "Rp. 51.900.000", "Rp. 36.200.000", "Rp. 21.400.000", "Rp. 22.000.000", "Rp. 29.000.000"};
            Integer[] gambar    = {R.drawable.szaddressf1, R.drawable.szgixersf, R.drawable.szgsxr150, R.drawable.sznexcrossover, R.drawable.sznexii, R.drawable.szsatriaf150};

            for (int i = 0; i < nama.length; i++) {
                setMotor(tvnama[i], nama[i], tvharga[i], harga[i], ivgambar[i], gambar[i], ll[i]);
            }
        }

        else if (id == 2) {

            tvMerk.setText("Motor Yamaha");
            String [] nama      = {"Fino", "Freego", "MIO M3", "X Ride", "VIXION", "YZ 125 X"};
            String [] harga     = {"Rp. 21.300.000","Rp. 22.500.000","Rp. 19.000.000", "Rp. 21.400.000", "Rp. 30.000.000", "80.000.000"};
            Integer [] gambar   = {R.drawable.ymfino, R.drawable.ymfreego, R.drawable.ymmiom3, R.drawable.ymxride, R.drawable.ymvixion, R.drawable.ym};

            for (int i = 0; i < nama.length; i++) {
                setMotor(tvnama[i], nama[i], tvharga[i], harga[i], ivgambar[i], gambar[i], ll[i]);
            }
        }

    }

    public void gokembali(View view){
//        Intent intent = new Intent (hlmdua.this, MainActivity.class);
//        startActivity(intent);
            finish();

    }


}