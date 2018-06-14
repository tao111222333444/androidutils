package com.hangzhou.androidutils.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ldp on 2015/8/7.
 */
public class BaseListViewHolder {
    private SparseArray<View> mViews;
    private View mConvertView;

    public BaseListViewHolder(Context context, ViewGroup parent, int layoutId) {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static BaseListViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new BaseListViewHolder(context, parent, layoutId);
        } else {
            return (BaseListViewHolder) convertView.getTag();
        }

    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    public BaseListViewHolder setChecked(int viewId,boolean isChecked){
        ImageView view = getView(viewId);
        view.setClickable(isChecked);
        return this;
    }

    public BaseListViewHolder setText(int viewId,String text){
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    public BaseListViewHolder setText(int viewId,SpannableStringBuilder text){
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    public BaseListViewHolder setImageResource(int viewId,int resId){
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public BaseListViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }
    public BaseListViewHolder setImageBitmap(int viewId,Drawable drawable){
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }
    public BaseListViewHolder setInvisible(int viewId,int isVisible){
        View view = getView(viewId);
        view.setVisibility(isVisible);
        return this;
    }

    public BaseListViewHolder setTextColor(int viewId,int color){
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    public LinearLayout getLinearLayout(int viewId){
        LinearLayout view = getView(viewId);
        return  view;
    }
    public void setButtonOnClick(int viewId, View.OnClickListener l){
      Button btn =  getView(viewId);
        btn.setOnClickListener(l);
    }

    public void setViewOnClick(int viewId, View.OnClickListener l){
        View btn =  getView(viewId);
        btn.setOnClickListener(l);
    }
}
