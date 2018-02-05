package com.xpjun.etumvp.viewlayer;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpjun.etumvp.toplayer.EtuAbsFragment;
import com.xpjun.etumvp.toplayer.Presenter;

/**
 * Created by Rirsa on 2018/2/5.
 */

public abstract class BaseFragment<PresenterType extends Presenter>
        extends EtuAbsFragment<PresenterType> implements View.OnClickListener{

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getContentView(),container,false);
        initView();
        initData();
        return view;
    }

    protected <T extends View>T $(@IdRes int viewID){
        return (T)view.findViewById(viewID);
    }

    protected void click(View v){
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int getContentView();
}
