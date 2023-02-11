package com.example.kreditmotorrfq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mViewPager = findViewById(R.id.viewPager);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        CardView gohonda, goyamaha, gosuzuki;
        gohonda = findViewById(R.id.honda);
        goyamaha = findViewById(R.id.yamaha);
        gosuzuki = findViewById(R.id.suzuki);


        gohonda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this , hlmdua.class);
                intent.putExtra("id", "1");
                startActivity(intent);
            }
        });

        goyamaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this , hlmdua.class);
                intent.putExtra("id", "2");
                startActivity(intent);
            }
        });

        gosuzuki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this , hlmdua.class);
                intent.putExtra("id", "3");
                startActivity(intent);
            }
        });

    }


    public void quit(View v) {
        finish();
        System.exit(0);
    }

}