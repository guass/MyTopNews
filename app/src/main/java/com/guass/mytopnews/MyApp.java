package com.guass.mytopnews;

import android.app.Application;

import com.guass.mytopnews.db.SQLHelper;

/**
 * Created by guass on 2016/9/29.
 */

public class MyApp extends Application {

    private static MyApp mAppApplication;
    private SQLHelper sqlHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this;
    }

    /** 获取Application */
    public static MyApp getApp() {
        return mAppApplication;
    }

    /** 获取数据库Helper */
    public SQLHelper getSQLHelper() {
        if (sqlHelper == null)
            sqlHelper = new SQLHelper(mAppApplication);
        return sqlHelper;
    }

    /** 摧毁应用进程时候调用 */
    public void onTerminate() {
        if (sqlHelper != null)
            sqlHelper.close();
        super.onTerminate();
    }

    public void clearAppCache()
    {
    }
}
