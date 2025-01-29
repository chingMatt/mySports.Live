package com.example.csc221finalproject_frontend;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SearchService {
    @FormUrlEncoded
    @POST("gameselection/sports")
    Call<Boolean> sports(@Field("sportsName") String sportsName);
}
