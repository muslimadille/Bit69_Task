package com.muslimadel2018.bit69_task.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.muslimadel2018.bit69_task.data.PostsClint;
import com.muslimadel2018.bit69_task.pojo.Categories;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesViewModel extends ViewModel {
    public MutableLiveData<List<Categories>> categoryMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public void getCategory() {
        PostsClint.getINISTANCE().getPosts().enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                categoryMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                errorMessage.setValue(t.getMessage());
            }
        });
    }
}
