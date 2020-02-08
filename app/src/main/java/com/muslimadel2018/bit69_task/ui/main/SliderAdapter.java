package com.muslimadel2018.bit69_task.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.muslimadel2018.bit69_task.R;

public class SliderAdapter extends PagerAdapter {
    private int[] imageResorces = {R.drawable.slider_a, R.drawable.slider_b, R.drawable.slider_d};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public SliderAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return imageResorces.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return (view == (RelativeLayout) o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swip_view, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.imageView18);
        imageView.setImageResource(imageResorces[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);

    }
}
