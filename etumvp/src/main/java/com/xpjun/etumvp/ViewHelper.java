package com.xpjun.etumvp;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Rirsa on 2018/2/2.
 * 视图帮助类，用于封装对presenter的操作，将presenter与view层解耦
 */

public class ViewHelper<presenterType extends Presenter> {

    private static final String PRESENTER_KEY = "presenter";
    private Object view;
    private presenterType presenter;

    public ViewHelper(Object view) {
        this.view = view;
    }

    protected presenterType getPresenter() {
        return presenter;
    }

    /*
     只在最开始创建的时候调用一次，做一下presenter的初始化工作
     通过savedInstanceState判断activity是否为异常情况退出，
     如果是则从缓存中取出之前的presenter，不是则重新创建一个presenter
     并存入内存中
     */
    protected void onCreate(Bundle savedInstanceState) {
        String id;
        if (savedInstanceState==null||(id= (String) savedInstanceState.get(PRESENTER_KEY))==null){
            //说明本次activity启动之前该activity不是异常退出，可直接重新创建presenter
            presenter = PresenterManager.getInstance().create(view);
        }else {
            presenter = PresenterManager.getInstance().getPresenter(id);
            if (presenter == null) presenter = PresenterManager.getInstance().create(view);
        }
        if (presenter!=null) presenter.create(view,savedInstanceState);
    }

    /*
    实际用作activity的onCreate方法回调的方法
     */
    public void onCreatedView(Bundle savedInstanceState) {
        //presenter.onCreatedView(view);
    }

    public void onSave(Bundle outState) {
        if (outState == null) return;
        outState.putString(PRESENTER_KEY,presenter.id);
        presenter.onSave(outState);
    }

    public void onStart() {
        presenter.onStart();
    }

    public void onResume() {
        presenter.onResume();
    }

    public void onPause() {
        presenter.onPause();
    }

    public void onStop() {
        presenter.onStop();
    }

    public void onDestroy() {
        presenter.onDestory();
    }

    public void onResult(int requestCode, int resultCode, Intent data) {
        presenter.onResult(requestCode,resultCode,data);
    }
}
