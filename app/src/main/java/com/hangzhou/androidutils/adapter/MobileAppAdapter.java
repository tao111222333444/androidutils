package com.hangzhou.androidutils.adapter;

import android.content.Context;

import com.hangzhou.androidutils.R;
import com.hangzhou.androidutils.base.BaseListAdapter;
import com.hangzhou.androidutils.base.BaseListViewHolder;
import com.hangzhou.androidutils.utils.AppInfoUtils;

/**
 * @author 作者：hugo
 * @date 时间：2018/6/8.
 * 版本：v1.0
 * 描述：
 */
public class MobileAppAdapter extends BaseListAdapter<AppInfoUtils.Application> {

    public MobileAppAdapter(Context context) {
        super(context,  R.layout.item_mobile_app_fragment);
    }

    @Override
    protected void convert(BaseListViewHolder holder, AppInfoUtils.Application o) {
        holder.setImageBitmap(R.id.iv_app_icon,o.getApplicationIcon())
                .setText(R.id.tv_app_name,o.getApplicationName())
                .setText(R.id.tv_app_package_name,o.getPackageName())
                .setText(R.id.tv_app_version,o.getVersion());
    }
}
