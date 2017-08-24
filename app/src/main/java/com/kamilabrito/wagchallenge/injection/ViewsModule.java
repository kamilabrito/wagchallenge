package com.kamilabrito.wagchallenge.injection;

import android.app.Activity;


import com.kamilabrito.wagchallenge.api.RetrofitApi;
import com.kamilabrito.wagchallenge.ui.MainActivityView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ViewsModule {

    private Activity mView;

    public ViewsModule(Activity view) {
        mView = view;
    }

    @ForApplication
    @Provides
    MainActivityView provideMainActivityView() {
        return (MainActivityView) mView;
    }

}
