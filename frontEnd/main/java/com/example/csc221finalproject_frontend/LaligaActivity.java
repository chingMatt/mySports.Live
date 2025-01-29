package com.example.csc221finalproject_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csc221finalproject_frontend.databinding.LaligaActivityBinding;

public class LaligaActivity extends AppCompatActivity {
    LaligaActivityBinding laligaActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        laligaActivityBinding = LaligaActivityBinding.inflate(getLayoutInflater());
        setContentView(laligaActivityBinding.getRoot());

        laligaActivityBinding.returnLaliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaligaActivity.this, SportsActivity.class);
                startActivity(intent);
            }
        });

        laligaActivityBinding.signoutLaliga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LaligaActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}


