package com.guass.mytopnews;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guass.mytopnews.activity.ChannelActivity;
import com.guass.mytopnews.activity.SearchActivity;
import com.guass.mytopnews.bean.ChannelItem;
import com.guass.mytopnews.bean.ChannelManage;
import com.guass.mytopnews.bean.NewsClassify;
import com.guass.mytopnews.tools.Constants;
import com.guass.mytopnews.utils.BaseTools;
import com.guass.mytopnews.view.ColumnHorizontalScrollView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "guass";
    protected SlidingMenu slidingMenu;
    /** 屏幕宽度 */
    private int mScreenWidth = 0;
    /** Item宽度 */
    private int mItemWidth = 0;
    /**自定义view*/
    private ColumnHorizontalScrollView mColumnHorizontalScrollView;

    protected LinearLayout mRadioGroup_content;
    protected LinearLayout ll_more_columns;
    protected RelativeLayout rl_column;
    protected ImageView button_more_columns;

    private ViewPager mViewPager;

    /** 左阴影部分*/
    public ImageView shade_left;
    /** 右阴影部分 */
    public ImageView shade_right;
    private EditText et_searchview;
    private SystemBarTintManager tintManager;
    /** 新闻分类列表*/
    private ArrayList<NewsClassify> newsClassify=new ArrayList<NewsClassify>();
    /**当前选择的栏目*/
   int  columnSelectIndex = 0;
    /** 用户栏目列表 */
    ArrayList<ChannelItem> userChannelList = new ArrayList<ChannelItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        mScreenWidth = BaseTools.getWindowsWidth(this);
        mItemWidth = mScreenWidth / 7; // 一个Item宽度为屏幕的1/7
        
        initView();
        initSlidingMenu();
    }

    private void initSlidingMenu()
    {
    }

    private void initView()
    {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
//        {
//            Window win = getWindow();
//            WindowManager.LayoutParams winParams = win.getAttributes();
//            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            winParams.flags |= bits;
//            win.setAttributes(winParams);
//            tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(R.color.colorPrimary);
//        }

        mColumnHorizontalScrollView = (ColumnHorizontalScrollView) findViewById(R.id.mColumnHorizontalScrollView);
        mRadioGroup_content = (LinearLayout) findViewById(R.id.mRadioGroup_content);
        ll_more_columns = (LinearLayout) findViewById(R.id.ll_more_columns);
        rl_column = (RelativeLayout) findViewById(R.id.rl_column);
        button_more_columns = (ImageView) findViewById(R.id.button_more_columns);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        shade_left = (ImageView) findViewById(R.id.shade_left);
        shade_right = (ImageView) findViewById(R.id.shade_right);

        et_searchview = (EditText) findViewById(R.id.et_searchview);
        et_searchview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "onClick: ");
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });

        button_more_columns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, ChannelActivity.class));
            }
        });

        setChangelView();
    }

    /**
     *  当栏目项发生变化时候调用
     * */
    private void setChangelView() {
        initColumnData();
        initTabColumn();
        initFragment();
    }

    private void initFragment()
    {
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "onResume: ");
        initView();
    }

    /** 获取Column栏目 数据*/
    private void initColumnData() {
 //       newsClassify = Constants.getData();
        userChannelList = ((ArrayList<ChannelItem>) ChannelManage.getManage(MyApp.getApp().getSQLHelper()).getUserChannel());
    }

    private void initTabColumn()
    {
        mRadioGroup_content.removeAllViews();
        int count = userChannelList.size();

        mColumnHorizontalScrollView.setParam(this, mScreenWidth, mRadioGroup_content, shade_left, shade_right, ll_more_columns, rl_column);
        for(int i = 0; i < count; i++)
        {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(mItemWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = 5;
            params.rightMargin = 5;
            //			TextView localTextView = (TextView) mInflater.inflate(R.layout.column_radio_item, null);
            TextView columnTextView = new TextView(this);
            columnTextView.setTextAppearance(this, R.style.top_category_scroll_view_item_text);
//			localTextView.setBackground(getResources().getDrawable(R.drawable.top_category_scroll_text_view_bg));
            columnTextView.setBackgroundResource(R.drawable.radio_buttong_bg);
            columnTextView.setGravity(Gravity.CENTER);
            columnTextView.setPadding(5, 5, 5, 5);
            columnTextView.setId(i);
//            columnTextView.setText(newsClassify.get(i).getTitle());
            columnTextView.setText(userChannelList.get(i).getName());
            columnTextView.setTextColor(getResources().getColorStateList(R.color.top_category_scroll_text_color_day));
            if(columnSelectIndex == i)
            {
                columnTextView.setSelected(true);
            }

            columnTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    for(int i = 0; i < mRadioGroup_content.getChildCount(); i++)
                    {
                        View localView = mRadioGroup_content.getChildAt(i);
                        if(localView != v)
                        {
                            Log.i(TAG, "onClick: 1");
                            localView.setSelected(false);
                        }
                        else
                        {
                            Log.i(TAG, "onClick: 2");
                            localView.setSelected(true);
                            mViewPager.setCurrentItem(i);
                        }
                    }
                }
            });
            mRadioGroup_content.addView(columnTextView,i,params);
        }


    }

}
