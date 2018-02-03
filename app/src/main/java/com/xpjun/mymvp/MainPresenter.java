package com.xpjun.mymvp;

import android.widget.Toast;

import com.xpjun.etumvp.Presenter;

/**
 * Created by Rirsa on 2018/2/3.
 */

public class MainPresenter extends Presenter<MainActivity> {

    @Override
    protected void onCreatedView(MainActivity view) {
        super.onCreatedView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getView(),"hhh",Toast.LENGTH_SHORT).show();
    }

    public void getText() {
        getView().setText("asdf");
    }
}
