package com.kamilabrito.wagchallenge.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.kamilabrito.wagchallenge.R;
import com.kamilabrito.wagchallenge.api.RetrofitApi;
import com.kamilabrito.wagchallenge.api.mapper.Mapper;
import com.kamilabrito.wagchallenge.api.model.BadgesCounts;
import com.kamilabrito.wagchallenge.api.model.Items;
import com.kamilabrito.wagchallenge.api.model.User;
import com.kamilabrito.wagchallenge.api.model.UserResponse;
import com.kamilabrito.wagchallenge.base.BasePresenter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by kamilabrito on 8/22/17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityView> {

    @Inject
    RetrofitApi mRetrofit;

    @Inject
    Mapper mMappter;

    @Inject
    public MainActivityPresenter() {
    }

    public void getUsersList() {
        getView().setProgressBarStatus(VISIBLE);
        Observable<UserResponse> call = mRetrofit.getUsers();
        subscribe(call, new Observer<UserResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull UserResponse userResponse) {
                getView().setProgressBarStatus(GONE);
                if (userResponse != null) {
                    List<Items> items = mMappter.mapUserResponse(userResponse);
                    getView().setUsersToList(items);
                } else {
                    getView().showToastMessage(R.string.no_users_available);
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {
                getView().setProgressBarStatus(GONE);
                getView().showToastMessage(R.string.connection_error);
                e.printStackTrace();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
