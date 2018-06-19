package com.hangzhou.androidutils.mobileApp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.hangzhou.androidutils.base.BaseActivity;
import com.hangzhou.androidutils.R;
import com.hangzhou.androidutils.utils.AutoAdaptionScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者：hugo
 * @date 时间：2018/6/8.
 * 版本：v1.0
 * 描述：
 */
public class MobileAppActivity extends BaseActivity {
    /**全部应用*/
    public static final int TYPE_1 = 0;
    /**系统应用*/
    public static final int TYPE_2 = 1;
    /**非系统应用*/
    public static final int TYPE_3 = 2;
    ViewPager mViewpager;


    List<Fragment> mFragments ;


    public static void  show(Context context){
        show(context,MobileAppActivity.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_app);
        AutoAdaptionScreenUtil.setWidthCustomDensity(this,getApplication());
        initializeView();
    }

    private void initializeView() {
        mViewpager = findViewById(R.id.mViewpager);
        mFragments = new ArrayList<>();

        mFragments.add(getMobileAppFragment(MobileAppFragment.TYPE_1));
        mFragments.add(getMobileAppFragment(MobileAppFragment.TYPE_2));
        mFragments.add(getMobileAppFragment(MobileAppFragment.TYPE_3));
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }
        };

        mViewpager.setAdapter(mAdapter);
        mViewpager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setTab(position);
            }
        });
        findViewById(R.id.btn_allApp).setOnClickListener(new textListener(TYPE_1));
        findViewById(R.id.btn_systemApp).setOnClickListener(new textListener(TYPE_2));
        findViewById(R.id.btn_NotSystemApp).setOnClickListener(new textListener(TYPE_3));
    }

    /**
     * 创建一个fragment并返回
     * */
    private MobileAppFragment getMobileAppFragment(int type){
        MobileAppFragment fragment = new MobileAppFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MobileAppFragment.INPUT_TYPE_KEY,type);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void setTab(int i){
        switch (i){
            case TYPE_1:
                //全部应用
                setTitle(R.string.mobile_app_text_1);
                break;
            case TYPE_2:
                //系统应用
                setTitle(R.string.mobile_app_text_2);
                break;
            case TYPE_3:
                //非系统应用
                setTitle(R.string.mobile_app_text_3);
                break;
            default:
        }
    }


    public class textListener implements View.OnClickListener {
        private int index = 0;

        public textListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            mViewpager.setCurrentItem(index);
        }

    }
}
