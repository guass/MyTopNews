package com.guass.mytopnews.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.guass.mytopnews.R;


/**
 * Created by Administrator on 2016/9/29 0029.
 */

public class MyToolbar extends Toolbar {

    private LayoutInflater mLayoutInflater;
    private EditText et;
    private TextView tv;
    private View view;
    
    public MyToolbar(Context context)
    {
        this(context,null);
    }

    public MyToolbar(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs,0);
    }

    public MyToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        
        initView();
    }

    private void initView()
    {
        if(view == null)
        {
            mLayoutInflater = LayoutInflater.from(getContext());
            view = mLayoutInflater.inflate(R.layout.toolbar_item, null);
            et = (EditText) findViewById(R.id.et_searchview);
            tv = (TextView) findViewById(R.id.tv_title);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(view, lp);


        }
    }

    @Override
    public void setTitle(@StringRes int resId)
    {
        setTitle(getContext().getText(resId));
    }

    @Override
    public void setTitle(CharSequence title)
    {
        initView();
        if(tv != null)
        {
            tv.setText(title);
        }
    }
}
