package com.hangzhou.androidutils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.hangzhou.androidutils.base.BaseActivity;
import com.hangzhou.androidutils.utils.AutoAdaptionScreenUtil;
import com.hangzhou.androidutils.utils.ScreenUtils;

/**
 * @author 作者：hugo
 * 时间：2018/6/8.
 * 版本：v1.0
 * 描述：
 */
public class ScreenInfoActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //以宽维度来适配该页面
        AutoAdaptionScreenUtil.setWidthCustomDensity(this,getApplication());
        setContentView(R.layout.activity_screen_info);
        getScreenInfo();
    }

    private void getScreenInfo() {
        TextView screenInfo = findViewById(R.id.tv_screenInfo);
        String str  = "标题栏高度:" + ScreenUtils.getTitleHeight(this) +
                "\n状态栏高度：" + ScreenUtils.getStatusBarHeight(this) +
                "\n屏幕宽度方法1：" + ScreenUtils.getScreenWidth(this) +
                "\n屏幕宽度方法2：" + ScreenUtils.getScreenWidth(getBaseContext()) +
                "\n屏幕宽度方法3：" + ScreenUtils.getScreenWidth2(this) +
                "\n包括虚拟键在内的总的屏幕高度：" + ScreenUtils.getTotalScreenHeight(this) +
                "\n不包括虚拟按键在内的屏幕高度1：" + ScreenUtils.getAvailableScreenHeight(getBaseContext()) +
                "\n不包括虚拟按键在内的屏幕高度2：" + ScreenUtils.getAvailableScreenHeight(this) +
                "\n虚拟按键的高度，不论虚拟按键是否显示：" + ScreenUtils.getNavigationBarHeight(this) +
                "\n虚拟按键的高度：" + ScreenUtils.getNavigationBarHeightIfShow(this) ;
        screenInfo.setText(str);
    }

    public static void show(Context context){
        Intent intent = new Intent(context,ScreenInfoActivity.class);
        context.startActivity(intent);
    }
}
