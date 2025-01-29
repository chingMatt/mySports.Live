package com.example.csc221finalproject_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csc221finalproject_frontend.databinding.NflActivityBinding;

public class NflActivity extends AppCompatActivity {
    NflActivityBinding nflActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nflActivityBinding = NflActivityBinding.inflate(getLayoutInflater());
        setContentView(nflActivityBinding.getRoot());

        nflActivityBinding.returnNfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NflActivity.this, SportsActivity.class);
                startActivity(intent);
            }
        });

        nflActivityBinding.signoutNfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NflActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
