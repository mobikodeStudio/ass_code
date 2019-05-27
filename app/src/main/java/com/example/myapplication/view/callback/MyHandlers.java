package com.example.myapplication.view.callback;

import android.content.Intent;
import android.view.View;

import com.example.myapplication.model.ArticlePojo;
import com.example.myapplication.ui.DetailsActivity;

/**
 * Created by Rakesh Prajapat on 2019-05-27
 * Copyright (c) 2019. All rights reserved by mobikode studio.
 * Last modified 10:59
 */
public class MyHandlers {
    public void onClickFriend(View v,ArticlePojo articlePojo) {
        Intent intent = new Intent(v.getContext(), DetailsActivity.class);
        intent.putExtra("data",articlePojo);
        v.getContext().startActivity(intent);
    }
}
