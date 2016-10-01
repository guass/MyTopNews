package com.guass.mytopnews.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.guass.mytopnews.R;


/**
 * Created by Administrator on 2016/9/30 0030.
 */

public class SearchToolbar extends Toolbar {

    private LayoutInflater mLayoutInflater;
    private View mView;
    private EditText et;
    private TextView tv;

    public SearchToolbar(Context context)
    {
        this(context,null);
    }

    public SearchToolbar(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs,0);
    }

    public SearchToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        intView();
    }

    public void intView()
    {
        if(mView == null)
        {
            mLayoutInflater = LayoutInflater.from(getContext());
            mView = mLayoutInflater.inflate(R.layout.toolbar_search_item, null);
            et = (EditText) findViewById(R.id.et_searchview_2);
            tv = (TextView) findViewById(R.id.tv_cancel);

            LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
            addView(mView, lp);
        }
    }
}
