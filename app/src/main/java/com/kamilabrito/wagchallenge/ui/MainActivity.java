package com.kamilabrito.wagchallenge.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kamilabrito.wagchallenge.R;
import com.kamilabrito.wagchallenge.api.model.Items;
import com.kamilabrito.wagchallenge.base.BaseActivity;
import com.kamilabrito.wagchallenge.injection.DaggerViewsComponent;
import com.kamilabrito.wagchallenge.injection.ViewsModule;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainActivityView {

    @BindView(R.id.recycler_view)
    RecyclerView mUserListRecyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @Inject
    MainActivityPresenter mPresenter;

    UserRecyclerViewAdapter mUserAdapter;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        mUserAdapter = new UserRecyclerViewAdapter(this);
        mUserListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUserListRecyclerView.setAdapter(mUserAdapter);

        mPresenter.getUsersList();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }


    @Override
    protected void resolveDaggerDependency() {
        DaggerViewsComponent.builder()
                .appComponent(getApplicationComponent())
                .viewsModule(new ViewsModule(this))
                .build().inject(this);

    }

    @Override
    public void setProgressBarStatus(int visible) {
        mProgressBar.setVisibility(visible);
    }

    @Override
    public void setUsersToList(List<Items> items) {
        mUserAdapter.addUsers(items);
    }

    @Override
    public void showToastMessage(int text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setImageOnView(Bitmap b) {

    }

}
