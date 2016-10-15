package com.guass.mytopnews.activity;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.guass.mytopnews.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by guass on 2016/10/1.
 */

public class SearchActivity extends AppCompatActivity {

    private SystemBarTintManager tintManager;
    private TextView tv_cancel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
//        {
//            Window win = getWindow();
//            WindowManager.LayoutParams winParams = win.getAttributes();
//            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            winParams.flags |= bits
//            win.setAttributes(winParams);
//            tintManager = new SystemBarTintManager(this);
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarTintResource(R.color.colorPrimary);
//        }

        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
