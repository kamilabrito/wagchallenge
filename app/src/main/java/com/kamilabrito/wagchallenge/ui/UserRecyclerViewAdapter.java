/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *            http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kamilabrito.wagchallenge.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kamilabrito.wagchallenge.R;
import com.kamilabrito.wagchallenge.api.model.Items;
import com.kamilabrito.wagchallenge.ui.component.RoundedImageView;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kamilabrito on 8/23/17.
 */

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    private List<Items> mItems = new ArrayList<>();
    private Context mContext;

    public UserRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final UserRecyclerViewAdapter.ViewHolder holder, int position) {
        final Items currentItem = mItems.get(position);

        if (currentItem != null) {
            holder.userName.setText(currentItem.getDisplay_name());
            holder.badgeGold.setText(currentItem.getBadge_counts().getGold()+"");
            holder.badgeSilver.setText(currentItem.getBadge_counts().getSilver()+"");
            holder.badgeBronze.setText(currentItem.getBadge_counts().getBronze()+"");
            holder.userImage.setDrawingCacheEnabled(true);
            Picasso.with(mContext)
                    .load(currentItem.getProfile_image())
                    .resize(60, 60)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(holder.userImage);
        }

    }

    @Override
    public int getItemCount() {
        return (null != mItems ? mItems.size() : 0);
    }

    public void addUsers(List<Items> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_iv_image)
        RoundedImageView userImage;
        @BindView(R.id.row_tv_username)
        TextView userName;
        @BindView(R.id.tv_badge_gold)
        TextView badgeGold;
        @BindView(R.id.tv_badge_silver)
        TextView badgeSilver;
        @BindView(R.id.tv_badge_bronze)
        TextView badgeBronze;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
