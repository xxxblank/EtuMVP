package com.xpjun.etumvp;

import android.os.Bundle;

/**
 * Created by Rirsa on 2018/2/2.
 * 最底层的presenter，生命周期方法与activity或fragment相对应
 */

public class Presenter<ViewType> {

    /*
    activity第一次创建的时候调用，之后直到退出都不会调用第二次
     */
    protected void onCreate(ViewType view, Bundle saveInstance){}

    /*
    activity的onCreate的回调，执行延迟到presenter的onCreate方法之后
     */
    protected void onCreatedView(ViewType view){}

    /*
    activity的onDestory的回调
     */
    protected void onDestoryView(){}

    /*
    presenter销毁的回调，表示activity正式退出
     */
    protected void onDestory(){}

    protected void onStart(){}
    protected void onResume(){}
    protected void onPause(){}
    protected void onStop(){}

}
