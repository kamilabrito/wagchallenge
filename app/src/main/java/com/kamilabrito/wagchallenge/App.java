package com.kamilabrito.wagchallenge;

import android.app.Application;

import com.kamilabrito.wagchallenge.injection.AppComponent;
import com.kamilabrito.wagchallenge.injection.AppModule;
import com.kamilabrito.wagchallenge.injection.DaggerAppComponent;

public class App extends Application {

    private final static String BASE_URL = "https://api.stackexchange.com/2.2/";
    protected AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    private void initializeApplicationComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, BASE_URL))
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}

