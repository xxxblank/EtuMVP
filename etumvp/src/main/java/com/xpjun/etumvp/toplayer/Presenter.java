package com.xpjun.etumvp.toplayer;

import android.content.Intent;
import android.os.Bundle;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Rirsa on 2018/2/2.
 * 最底层的presenter，生命周期方法与activity或fragment相对应
 */

public class Presenter<ViewType> {

    private Reference<ViewType> viewRef;

    /*
    activity第一次创建的时候调用，之后直到退出都不会调用第二次
     */
    protected void onCreate(ViewType view, Bundle saveInstance){}

    /*
    activity的onCreate的回调，执行延迟到presenter的onCreate方法之后
     */
    protected void onCreatedView(ViewType view){
        viewRef = new WeakReference<ViewType>(view);
    }

    public ViewType getView(){
        return viewRef.get();
    }

    /*
    activity的onDestory的回调
     */
    protected void onDestoryView(){}

    /*
    presenter销毁的回调，表示activity正式退出
     */
    protected void onDestory(){
        if (viewRef!=null){
            viewRef.clear();
            viewRef = null;
        }
    }

    protected void onStart(){}
    protected void onResume(){}
    protected void onPause(){}
    protected void onStop(){}

    protected String id;

    public void bind(ViewType view,Bundle saveInstance){
        viewRef = new WeakReference<ViewType>(view);
        onCreate(viewRef.get(),saveInstance);
    }

    public void onResult(int requestCode, int resultCode, Intent data) {

    }

    public void onSave(Bundle state){

    }
}
