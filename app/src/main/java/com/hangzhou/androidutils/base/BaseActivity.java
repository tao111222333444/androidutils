package com.hangzhou.androidutils.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.hangzhou.androidutils.utils.ToastUtil;

/**
 * 基类activity
 * @author 29794
 */
@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

    protected void showToast(String msg){
        ToastUtil.showToast(this,msg);
    }

    protected void showToastLong(String msg){
        ToastUtil.showToastLong(this,msg);
    }

    protected static void show(Context context, Class<?> cls){
        Intent intent = new Intent(context,cls);
        context.startActivity(intent);
    }

}
