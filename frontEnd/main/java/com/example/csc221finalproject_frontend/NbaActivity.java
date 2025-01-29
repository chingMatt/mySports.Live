package com.example.csc221finalproject_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csc221finalproject_frontend.databinding.NbaActivityBinding;

public class NbaActivity extends AppCompatActivity {
    NbaActivityBinding nbaActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nbaActivityBinding = NbaActivityBinding.inflate(getLayoutInflater());
        setContentView(nbaActivityBinding.getRoot());

        nbaActivityBinding.returnNba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NbaActivity.this, SportsActivity.class);
                startActivity(intent);
            }
        });

        nbaActivityBinding.signoutNba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NbaActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
