package com.kamilabrito.wagchallenge.ui;

import android.graphics.Bitmap;

import com.kamilabrito.wagchallenge.api.model.Items;
import com.kamilabrito.wagchallenge.base.BaseView;

import java.util.List;

/**
 * Created by kamilabrito on 8/22/17.
 */

public interface MainActivityView extends BaseView {
    void setProgressBarStatus(int visible);

    void setUsersToList(List<Items> items);

    void showToastMessage(int text);

    void setImageOnView(Bitmap b);
}
