package com.muslimadel2018.bit69_task.ui.products;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.muslimadel2018.bit69_task.R;
import com.muslimadel2018.bit69_task.pojo.Categories;
import com.muslimadel2018.bit69_task.pojo.Product;
import com.muslimadel2018.bit69_task.viewModel.CategoriesViewModel;
import com.muslimadel2018.bit69_task.ui.productDetails.ProductDetails;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends AppCompatActivity {
    private ArrayList<Product> products;
    private ProductsAdapter productsAdapter;
    private RecyclerView recyclerView;
    private CategoriesViewModel categoriesViewModel;
    private int category_index;
    private Intent mIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        mIntent = getIntent();
        category_index = mIntent.getIntExtra("INDEX", 0);
        recyclerView = findViewById(R.id.product_recycler_view);
        categoriesViewModel = ViewModelProviders.of(this).get(CategoriesViewModel.class);
        categoriesViewModel.getCategory();

        categoriesViewModel.categoryMutableLiveData.observe(this, new Observer<List<Categories>>() {
            @Override
            public void onChanged(final List<Categories> categories) {
                products = (ArrayList<Product>) categories.get(category_index).getProducts();
                productsAdapter = new ProductsAdapter(ProductPage.this, products);
                recyclerView.setAdapter(productsAdapter);
                productsAdapter.setOnItemClickListener(new ProductsAdapter.OnItimeClickListner() {
                    @Override
                    public void onItemClick(int position) {
                        String product_name = products.get(position).getName();
                        Intent intent = new Intent(ProductPage.this, ProductDetails.class);
                        intent.putExtra("NAME", product_name);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
