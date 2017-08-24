package com.kamilabrito.wagchallenge.injection;

import com.kamilabrito.wagchallenge.ui.MainActivity;
import com.kamilabrito.wagchallenge.ui.MainActivityView;

import dagger.Component;

@ForApplication
@Component(modules = ViewsModule.class, dependencies = AppComponent.class)
public interface ViewsComponent {

    void inject(MainActivity activity);

}