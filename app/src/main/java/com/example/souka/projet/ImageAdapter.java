package com.example.souka.projet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h,
            R.drawable.i, R.drawable.j,
            R.drawable.k,
            R.drawable.l, R.drawable.m,
            R.drawable.n, R.drawable.o,
            R.drawable.p,
            R.drawable.q, R.drawable.r,
            R.drawable.s, R.drawable.t,
            R.drawable.u,
            R.drawable.v, R.drawable.w,
            R.drawable.x, R.drawable.y,
            R.drawable.z,



    };
    public ImageAdapter(Context c) {
        mContext = c;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mThumbIds[position];
    }

    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //    imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
        return imageView;
    }
}
