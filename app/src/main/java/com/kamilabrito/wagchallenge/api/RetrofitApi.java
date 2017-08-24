package com.kamilabrito.wagchallenge.api;

import com.kamilabrito.wagchallenge.api.model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("users?site=stackoverflow")
    Observable<UserResponse> getUsers();

}


