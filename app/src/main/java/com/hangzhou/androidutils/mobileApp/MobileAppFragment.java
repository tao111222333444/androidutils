package com.hangzhou.androidutils.mobileApp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hangzhou.androidutils.R;
import com.hangzhou.androidutils.adapter.MobileAppAdapter;
import com.hangzhou.androidutils.utils.AppInfoUtils;

import java.util.List;


/**
 * @author 作者：hugo
 * @date 时间：2018/6/8.
 * 版本：v1.0
 * 描述：
 */
public class MobileAppFragment extends Fragment {
    /**传入值的key*/
    public static final String INPUT_TYPE_KEY = "input_type_key";
    /**全部应用*/
    public static final int TYPE_1 = 1;
    /**系统应用*/
    public static final int TYPE_2 = 2;
    /**非系统应用*/
    public static final int TYPE_3 = 3;


    private int type = 1;

    private ListView listview;
    private MobileAppAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mobile_app,container,false);
        initialize(view);
        return view;
    }


    private void initialize(View view) {
        if (getArguments() != null) {
            type = getArguments().getInt(INPUT_TYPE_KEY,1);
        }
        listview = view.findViewById(R.id.listview);
        mAdapter = new MobileAppAdapter(getContext());
        listview.setAdapter(mAdapter);
        List<AppInfoUtils.Application> list;
        switch (type){
            case TYPE_1:
                list = AppInfoUtils.getAllApplication(getContext());
                break;
            case TYPE_2:
                list = AppInfoUtils.getAllSystemApplication(getContext());
                break;
            case TYPE_3:
                list = AppInfoUtils.getAllNonSystemApplication(getContext());
                break;
            default:
                list = AppInfoUtils.getAllApplication(getContext());
        }
        mAdapter.setDatas(list);

    }
}
