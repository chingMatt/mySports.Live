package com.example.csc221finalproject_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csc221finalproject_frontend.databinding.SearchActivityBinding;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private SearchService searchService;
    SearchActivityBinding searchActivityBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchActivityBinding = SearchActivityBinding.inflate(getLayoutInflater());
        setContentView(searchActivityBinding.getRoot());

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.184:8080/").addConverterFactory(GsonConverterFactory.create()).build();
        searchService = retrofit.create(SearchService.class);

        searchActivityBinding.searchBtn.setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View view) {
        String sportsName = searchActivityBinding.Search.getEditableText().toString();


        searchActivityBinding.invalidMsg.setVisibility(View.INVISIBLE);

        boolean valid = authenticate(sportsName);

        if(valid) {
            Call<Boolean> response = searchService.sports(sportsName);
            response.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if (response.body()) {
                        Intent intent = new Intent(getBaseContext(), SportsActivity.class);
                        startActivity(intent);

                    } else {
                        searchActivityBinding.invalidMsg.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    System.out.println("Error");
                }


            });

        }

    }

    private boolean authenticate (String sportsName) {
        if (sportsName.isEmpty()) {
            searchActivityBinding.Search.setError("Please type in a sport");
            return false;
        }


        return true;
    }
}
