package com.kamilabrito.wagchallenge.api.mapper;

import android.content.ClipData;
import android.util.Log;

import com.kamilabrito.wagchallenge.api.model.BadgesCounts;
import com.kamilabrito.wagchallenge.api.model.Items;
import com.kamilabrito.wagchallenge.api.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by kamilabrito on 8/23/17.
 */

public class Mapper {

    @Inject
    public Mapper() {
    }

    public List<Items> mapUserResponse(UserResponse userResponse) {
        List<Items> items = new ArrayList<>();

        if (userResponse != null) {
            for (int i = 0; i < userResponse.getItems().length; i++) {
                Items item = new Items();
                BadgesCounts badgesCounts = new BadgesCounts();
                badgesCounts.setBronze(userResponse.getItems()[i].getBadge_counts().getBronze());
                badgesCounts.setSilver(userResponse.getItems()[i].getBadge_counts().getSilver());
                badgesCounts.setGold(userResponse.getItems()[i].getBadge_counts().getGold());

                item.setBadge_counts(badgesCounts);
                item.setDisplay_name(userResponse.getItems()[i].getDisplay_name());
                item.setProfile_image(userResponse.getItems()[i].getProfile_image());
                items.add(item);
            }
        }
        return items;
    }
}
