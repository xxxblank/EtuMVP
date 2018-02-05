package com.xpjun.mymvp;

import com.xpjun.etumvp.BaseDataActivityPresenter;
import io.reactivex.Observable;

/**
 * Created by Rirsa on 2018/2/3.
 */

public class MainActivityPresenter
        extends BaseDataActivityPresenter<MainActivity,String> {

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void getText() {
        //Observable.just("asdfffff").subscribe(getDataSubscriber());
        MainModel.getData("abcdefg").subscribe(getDataSubscriber());
    }
}
