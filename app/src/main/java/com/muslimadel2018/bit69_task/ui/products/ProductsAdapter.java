package com.muslimadel2018.bit69_task.ui.products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.muslimadel2018.bit69_task.R;
import com.muslimadel2018.bit69_task.pojo.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    private OnItimeClickListner mListner;

    public interface OnItimeClickListner {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItimeClickListner listener) {
        mListner = listener;
    }

    private ArrayList<Product> products = new ArrayList<>();
    private Context context;

    public ProductsAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ProductsAdapter.ViewHolder(view, mListner);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(products.get(position).getName());
        holder.desc.setText(products.get(position).getWeight());
        holder.price.setText(products.get(position).getPrice());
        Picasso.get().load(products.get(position).getProductImg()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImage;
        private TextView title, desc, price;


        public ViewHolder(@NonNull View itemView, final OnItimeClickListner listner) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            price = itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listner != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listner.onItemClick(position);
                        }

                    }

                }
            });


        }


    }

}
