package com.example.csc221finalproject_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csc221finalproject_frontend.databinding.SportsActivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportsActivity extends AppCompatActivity  {


    private SportsActivityBinding sportsActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sportsActivityBinding = SportsActivityBinding.inflate(getLayoutInflater());
        setContentView(sportsActivityBinding.getRoot());

        sportsActivityBinding.nflBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportsActivity.this, NflActivity.class);
                startActivity(intent);
            }
        });

        sportsActivityBinding.laligaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportsActivity.this, LaligaActivity.class);
                startActivity(intent);
            }
        });

        sportsActivityBinding.nbaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportsActivity.this, NbaActivity.class);
                startActivity(intent);
            }
        });


    }

}
