package com.hangzhou.androidutils;

import android.os.Bundle;
import android.view.View;

import com.hangzhou.androidutils.base.BaseActivity;
import com.hangzhou.androidutils.mobileApp.MobileAppActivity;
import com.hangzhou.androidutils.utils.AppInfoUtils;
import com.hangzhou.androidutils.utils.AutoAdaptionScreenUtil;
import com.hangzhou.androidutils.utils.LogUtil;
import com.hangzhou.androidutils.utils.ToastUtil;
import com.hangzhou.androidutils.utils.Utils;

import java.util.List;

/**
 *
 * @author 29794
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoAdaptionScreenUtil.setWidthCustomDensity(this,getApplication());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_screen:
                //屏幕尺寸
//                ScreenInfoActivity.show(this);
                ToastUtil.showToast("hahahahhahahahhahahaha");
                break;
            case R.id.btn_open_market:
                //打开应用市场到qq详情页面
                Utils.openApplicationMarket(this,"com.tencent.mobileqq");
                break;
            case R.id.btn_appInfo:
                //应用信息
                AppInfoActivity.show(this);
                break;
            case R.id.btn_all_app:
                //手机里app的信息
                MobileAppActivity.show(this);
//                List<AppInfoUtils.Application> list = AppInfoUtils.getAllSystemApplication(getApplicationContext());
//                for (AppInfoUtils.Application aa : list){
//                    LogUtil.e(aa.getApplicationName(),aa.getVersion());
//                }
                break;

            default:
        }
    }
}
