package com.example.myapplication.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ArticleViewBinding;
import com.example.myapplication.model.ArticlePojo;
import com.example.myapplication.view.callback.MyHandlers;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Rakesh Prajapat on 2019-05-26
 * Copyright (c) 2019. All rights reserved by mobikode studio.
 * Last modified 18:43
 */
public class NyArticleListAdapter extends RecyclerView.Adapter<NyArticleListAdapter.viewHolder> {

    private Context context;
    private List<ArticlePojo> articleList = new ArrayList<>();
    public NyArticleListAdapter(Context context, List<ArticlePojo> articleList) {
        this.context = context;
        this.articleList = articleList;
    }


    public static class viewHolder extends RecyclerView.ViewHolder{


        ArticleViewBinding itemLayoutBinding;

        public viewHolder(@NonNull ArticleViewBinding itemView) {
            super(itemView.getRoot());
            this.itemLayoutBinding =itemView;
        }
        public void bind(ArticlePojo obj) {
            itemLayoutBinding.setArticlePojo(obj);
            itemLayoutBinding.setHandlers(new MyHandlers());
            itemLayoutBinding.executePendingBindings();
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        ArticleViewBinding itemBinding =
                ArticleViewBinding.inflate(layoutInflater, parent, false);
        return new viewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int position) {
        ArticlePojo pojo = articleList.get(position);
        viewHolder.bind(pojo);
        Glide.with(viewHolder.itemLayoutBinding.profileImage.getContext())
                .load(pojo.getMedia().get(0).getMedia_metadata().get(0).getUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.itemLayoutBinding.profileImage);


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
