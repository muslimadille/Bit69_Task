package com.muslimadel2018.bit69_task.data;
import com.muslimadel2018.bit69_task.pojo.Categories;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("categories")
     Call<List<Categories>> getpost();
}
