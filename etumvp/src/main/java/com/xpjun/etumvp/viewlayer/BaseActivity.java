package com.xpjun.etumvp.viewlayer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.xpjun.etumvp.toplayer.EtuAbsActivity;
import com.xpjun.etumvp.toplayer.Presenter;

/**
 * Created by Rirsa on 2018/2/5.
 */

public abstract class BaseActivity<PresenterType extends Presenter>
        extends EtuAbsActivity<PresenterType> implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        initData();
    }

    protected abstract void initData();

    protected void click(View v){
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    protected abstract void initView();

    protected abstract int getContentView();

    protected <T extends View>T $(@IdRes int viewId){
        T view = (T)findViewById(viewId);
        return view;
    }
}
