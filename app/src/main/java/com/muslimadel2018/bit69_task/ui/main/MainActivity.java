package com.muslimadel2018.bit69_task.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.muslimadel2018.bit69_task.R;
import com.muslimadel2018.bit69_task.pojo.Categories;
import com.muslimadel2018.bit69_task.ui.products.ProductPage;
import com.muslimadel2018.bit69_task.viewModel.CategoriesViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private SliderAdapter ViewPager_adapter;
    private CategoriesViewModel categoriesViewModel;
    private TextView title1, title2, title3, title4;
    private ImageView itemImage1, itemImage2, itemImage3, itemImage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriesViewModel = ViewModelProviders.of(this).get(CategoriesViewModel.class);
        categoriesViewModel.getCategory();

        title1 = findViewById(R.id.c1_text);
        title2 = findViewById(R.id.c2_text);
        title3 = findViewById(R.id.c3_text);
        title4 = findViewById(R.id.c4_text);

        itemImage1 = findViewById(R.id.c1_image);
        itemImage2 = findViewById(R.id.c2_image);
        itemImage3 = findViewById(R.id.c3_image);
        itemImage4 = findViewById(R.id.c4_image);

        viewPager = (ViewPager) findViewById(R.id.viewPAGER);
        ViewPager_adapter = new SliderAdapter(this);
        viewPager.setAdapter(ViewPager_adapter);
        Timer timer = new Timer();

        //slider period
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

        //get data from view model
        categoriesViewModel.categoryMutableLiveData.observe(this, new Observer<List<Categories>>() {
            @Override
            public void onChanged(List<Categories> categories) {
                String name1 = categories.get(0).getName();
                String name2 = categories.get(1).getName();
                String name3 = categories.get(2).getName();
                String name4 = categories.get(3).getName();
                title1.setText(name1);
                title2.setText(name2);
                title3.setText(name3);
                title4.setText(name4);
                String img1 = categories.get(0).getCategoryImg();
                String img2 = categories.get(1).getCategoryImg();
                String img3 = categories.get(2).getCategoryImg();
                String img4 = categories.get(3).getCategoryImg();
                Picasso.get().load(img1).into(itemImage1);
                Picasso.get().load(img2).into(itemImage2);
                Picasso.get().load(img3).into(itemImage3);
                Picasso.get().load(img4).into(itemImage4);

            }
        });
    }

    public void item1Click(View view) {
        Intent intent = new Intent(MainActivity.this, ProductPage.class);
        intent.putExtra("INDEX", 0);
        startActivity(intent);
    }

    public void item2Click(View view) {
        Intent intent = new Intent(MainActivity.this, ProductPage.class);
        intent.putExtra("INDEX", 1);
        startActivity(intent);
    }

    public void item3Click(View view) {
        Intent intent = new Intent(MainActivity.this, ProductPage.class);
        intent.putExtra("INDEX", 2);
        startActivity(intent);
    }

    public void item4Click(View view) {
        Intent intent = new Intent(MainActivity.this, ProductPage.class);
        intent.putExtra("INDEX", 3);
        startActivity(intent);
    }

    //controlling slider class
    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }

            });
        }
    }
}
