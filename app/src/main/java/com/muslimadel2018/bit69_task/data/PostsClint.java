package com.muslimadel2018.bit69_task.data;

import com.muslimadel2018.bit69_task.pojo.Categories;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClint {
    private static final String BASE_URL = "https://5bcce576cf2e850013874767.mockapi.io/task/";
    private PostInterface postInterface;
    private static PostsClint INISTANCE;


    public PostsClint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClint getINISTANCE() {
        if (null == INISTANCE) {
            INISTANCE = new PostsClint();
        }
        return INISTANCE;
    }

    public Call<List<Categories>> getPosts() {
        return postInterface.getpost();
    }
}
