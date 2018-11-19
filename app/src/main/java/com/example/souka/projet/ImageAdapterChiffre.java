package com.example.souka.projet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapterChiffre extends BaseAdapter {

    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.a0, R.drawable.a1,
            R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5,
            R.drawable.a6, R.drawable.a7,
            R.drawable.a8, R.drawable.a9,
            R.drawable.a10,
           


    };
    public ImageAdapterChiffre(Context c) {
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
