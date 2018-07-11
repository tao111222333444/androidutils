package com.hangzhou.androidutils;

import android.app.Application;
import android.os.Handler;

import com.hangzhou.androidutils.utils.ToastUtil;

/**
 * @author 作者：hugo
 * @date 时间：2018/7/11.
 * 版本：v1.0
 * 描述：
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtil.setMainHander(new Handler(getMainLooper()),this);
    }

    /**
     * 程序终止的时候执行
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        ToastUtil.clear();
    }
}
