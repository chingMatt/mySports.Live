package com.example.csc221finalproject_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.csc221finalproject_frontend.databinding.UserActivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity implements View.OnClickListener{

    private UserService userService;
    UserActivityBinding userActivityBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userActivityBinding = UserActivityBinding.inflate(getLayoutInflater());
        setContentView(userActivityBinding.getRoot());

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.1.184:8080/").addConverterFactory(GsonConverterFactory.create()).build();
        userService = retrofit.create(UserService.class);

        userActivityBinding.loginBtn.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        String userid = userActivityBinding.UserID.getEditableText().toString();
        String password = userActivityBinding.Password.getEditableText().toString();

        userActivityBinding.errorMessage.setVisibility(View.INVISIBLE);

        boolean valid = authenticate(userid, password);

        if(valid) {
            Call<Boolean> response = userService.login(userid, password);
            response.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if (response.body()) {
                        Intent intent = new Intent(getBaseContext(), SearchActivity.class);
                        startActivity(intent);
                    } else {
                        userActivityBinding.errorMessage.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    System.out.println("Error");
                }

            });

        }

    }

    private boolean authenticate (String userid, String password) {
        if (userid.isEmpty()) {
            userActivityBinding.UserID.setError("Must enter an userid");
            return false;
        } else if (password.isEmpty()) {
            userActivityBinding.Password.setError("Must enter a password");
            return false;
        }

        return true;
    }
}
