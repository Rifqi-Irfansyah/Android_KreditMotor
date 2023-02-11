package com.example.kreditmotorrfq;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class hlmtiga extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String nama, harga;
    Integer picture, durasi, cicil, dp;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hlmtiga);

        getIncomingIntent();

        TextView tvnama, tvharga;
        ImageView ivgambar;


        tvnama = findViewById(R.id.nama);
        tvharga = findViewById(R.id.harga);
        ivgambar = findViewById(R.id.gambar);

        tvnama.setText(nama);
        tvharga.setText(harga);
        ivgambar.setImageResource(picture);

//        setContentView(R.layout.activity_hlmtiga);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(hlmtiga.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }


    public static String currencyWithChosenLocalisation(double value, Locale locale) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(value);
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("nama") && getIntent().hasExtra("harga") && getIntent().hasExtra("gambar")) {
            nama = getIntent().getStringExtra("nama");
            harga = getIntent().getStringExtra("harga");
            picture = getIntent().getIntExtra("gambar", 0);

        }
    }

    private Spinner spinner;
    private static final String[] paths = {"3 bulan", "6 bulan", "12 bulan"};


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {


        switch (position) {
            case 0:
                durasi = 3;
                break;
            case 1:
                durasi = 6;
                break;
            case 2:
                durasi = 12;
                break;
        }
    }

    public void gokembali(View view){
//        Intent intent = new Intent (hlmdua.this, MainActivity.class);
//        startActivity(intent);
        finish();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }




    public void openAlertDialog(View view) {
        EditText etMuka;
        etMuka = findViewById(R.id.dp);
        Integer muka=0;

        try {
            muka = Integer.parseInt(String.valueOf(etMuka.getText()));
        }
        catch(NumberFormatException a) {
            muka = null;
        }

        if(muka==null){
            Toast.makeText(hlmtiga.this, "Harus Menyertakan Dp", Toast.LENGTH_SHORT).show();
        }
        else if(muka<2000000){
            Toast.makeText(hlmtiga.this, "Minimal Pembayaran DP RP 2.000.000", Toast.LENGTH_SHORT).show();
        }

        else {
            harga = harga.replace("Rp. ", "");
            harga = harga.replace(".", "");

            cicil = Integer.parseInt(harga);
            cicil = cicil - muka;
            cicil = cicil / durasi;

            new AlertDialog.Builder(this)

                    .setTitle("Kredit Motor ")
                    .setMessage("Nama Motor      \t: " + nama + "\nRentang Waktu \t: " + durasi + " bulan" + "\nUang Muka/DP  \t: Rp. " + muka + "\n\nCicilan perbulan \t: " + "Rp. " + cicil)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(hlmtiga.this, "Kamu memilih OK", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }

    }

}
