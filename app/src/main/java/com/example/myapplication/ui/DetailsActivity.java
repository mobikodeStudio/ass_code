package com.example.myapplication.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityDetailsBinding;
import com.example.myapplication.model.ArticlePojo;
import com.example.myapplication.viewmodel.DetailsActivityViewModel;
import com.example.myapplication.viewmodel.MainActivityViewModel;

/**
 * Created by Rakesh Prajapat on 2019-05-27
 * Copyright (c) 2019. All rights reserved by mobikode studio.
 * Last modified 11:19
 */
public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    private DetailsActivityViewModel viewModel;
    private ArticlePojo pojo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        setContentView(binding.getRoot());
        pojo= (ArticlePojo) getIntent().getParcelableExtra("data");
        binding.setArticlePojo(pojo);
        viewModel = ViewModelProviders.of(this).get(DetailsActivityViewModel.class);
        viewModel.init();
        Glide.with(binding.profileImage.getContext())
                .load(pojo.getMedia().get(0).getMedia_metadata().get(3).getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.profileImage);

    }
}
