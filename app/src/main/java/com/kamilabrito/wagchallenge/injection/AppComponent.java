package com.kamilabrito.wagchallenge.injection;

import android.content.Context;

import com.kamilabrito.wagchallenge.api.RetrofitApi;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    RetrofitApi exposeRetrofitApi();
    Context exposeContext();
}
