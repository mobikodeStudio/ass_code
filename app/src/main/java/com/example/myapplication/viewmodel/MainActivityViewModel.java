package com.example.myapplication.viewmodel;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.model.ArticlePojo;
import com.example.myapplication.networking.ArticleRepository;

import static com.example.myapplication.utils.Constants.API_KEY;

/**
 * Created by Rakesh Prajapat on 2019-05-26
 * Copyright (c) 2019. All rights reserved by mobikode studio.
 * Last modified 12:55
 */
public class MainActivityViewModel extends ViewModel  {

    private MutableLiveData<ArticlePojo> mutableLiveData;
    private ArticleRepository articleRepository;




    public void init(){
        if (mutableLiveData != null){
            return;
        }
        articleRepository = ArticleRepository.getInstance();
        mutableLiveData = articleRepository.getNews( API_KEY);

    }

    public MutableLiveData<ArticlePojo> getArticleList()
    {

        return mutableLiveData;
    }
}
