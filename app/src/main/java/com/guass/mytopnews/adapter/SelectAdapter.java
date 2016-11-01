package com.guass.mytopnews.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.guass.mytopnews.R;

/**
 * Created by Guasszjg on 2016/11/1 0001.
 * Email:guasszjg@gmail.com
 */

public class SelectAdapter extends BaseAdapter {

    private static final String TAG = "guass";

    private int[] mImages = new int[]{R.drawable.ic_video_black_24dp,R.drawable.ic_my_black_24dp,R.drawable.ic_favorite_border_black_24dp,R.drawable.ic_home_black_24dp,R.mipmap.ic_action_name};
    private LayoutInflater mLayoutInflater;

    public SelectAdapter(Context context)
    {

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()
    {
        return mImages.length;
    }

    @Override
    public Object getItem(int position)
    {
        return mImages[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.activity_item,null);
            Log.i(TAG, "convertView: " + convertView);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.iv);
            Log.i(TAG, "mImageView: " + viewHolder.mImageView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mImageView.setBackgroundResource(mImages[position]);
        if(position != mImages.length -1)
        {
            viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Log.i(TAG, "onClick: " + position);
                }
            });
        }
        return convertView;
    }

    class ViewHolder{
        ImageView mImageView;
    }
}
