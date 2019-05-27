package com.example.myapplication.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.model.ArticlePojo;
import com.example.myapplication.view.adapter.NyArticleListAdapter;
import com.example.myapplication.viewmodel.MainActivityViewModel;



public class MainActivity extends AppCompatActivity {

private MainActivityViewModel viewModel;
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        android.databinding.DataBindingComponent a = DataBindingUtil.getDefaultComponent();
        setContentView(binding.getRoot());



        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        setRecyclerView();
        viewModel.init();
        viewModel.getArticleList().observe(this, new Observer<ArticlePojo>() {

            @Override
            public void onChanged(@Nullable ArticlePojo articlePojo) {
                  binding.rvNyArticles.setAdapter(new NyArticleListAdapter(MainActivity.this,
                          articlePojo.getResults()));
            }
        });
    }

    private void setRecyclerView() {
        binding.rvNyArticles.setLayoutManager( new LinearLayoutManager(this));
        binding.rvNyArticles.setHasFixedSize(true);

    }


}
