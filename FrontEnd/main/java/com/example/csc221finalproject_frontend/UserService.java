package com.example.csc221finalproject_frontend;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("user/login")
    Call<Boolean> login(@Field("userid") String userid, @Field("password") String password);


}
