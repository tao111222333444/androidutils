package com.hangzhou.androidutils;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.hangzhou.androidutils.base.BaseActivity;
import com.hangzhou.androidutils.utils.AutoAdaptionScreenUtil;
import com.hangzhou.androidutils.utils.Utils;

/**
 * @author 作者：hugo
 * @date 时间：2018/6/8.
 * 版本：v1.0
 * 描述：
 */
public class AppInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);
        //高维度来适配
        AutoAdaptionScreenUtil.setHeightCustomDensity(this,getApplication());
        getAppInfo();
    }

    private void getAppInfo() {
        TextView appInfo = findViewById(R.id.tv_appInfo);
        String str = "当前应用进程名："+ Utils.getProcessName(this,android.os.Process.myPid()) +
                "\n应用版本名：" +Utils.getVersionName(this) +
                "\n应用版本号：" + Utils.getLocalVersionCode(this);
        appInfo.setText(str);
    }

    public static void show(Context context){
        show(context,AppInfoActivity.class);
    }
}
