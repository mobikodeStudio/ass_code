package com.example.myapplication.networking;



import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.myapplication.model.ArticlePojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {


    private static ArticleRepository articleRepository;

    public static ArticleRepository getInstance(){
        if (articleRepository == null){
            articleRepository = new ArticleRepository();
        }
        return articleRepository;
    }

    private ArticleApi newsApi;

    public ArticleRepository(){
        newsApi = RetrofitService.cteateService(ArticleApi.class);
    }

    public MutableLiveData<ArticlePojo> getNews(String key){
        final MutableLiveData<ArticlePojo> newsData = new MutableLiveData<>();

        newsApi.getNewsList( key).enqueue(new Callback<ArticlePojo>() {
            @Override
            public void onResponse(Call<ArticlePojo> call,
                                   Response<ArticlePojo> response) {

                Log.d("DDDD" , "Article"  + response.toString());
                if (response.isSuccessful()){
                    Log.d("DDDD" , "Article"  + response.toString());
                    newsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArticlePojo> call, Throwable t)
            {
                Log.d("DDDD" , "Article"  + t.toString());
                Log.d("DDDD" , "Article"  + call.toString());
                t.printStackTrace();
                newsData.setValue(null);
            }
        });
        return newsData;
    }
}
