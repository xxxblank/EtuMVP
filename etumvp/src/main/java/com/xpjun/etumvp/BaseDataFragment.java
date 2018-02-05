package com.xpjun.etumvp;


import com.xpjun.etumvp.toplayer.Presenter;
import com.xpjun.etumvp.viewlayer.BaseFragment;

/**
 * Created by Rirsa on 2018/2/5.
 */

public abstract class BaseDataFragment<PresenterType extends Presenter,ModelType>
        extends BaseFragment<PresenterType> {

    public abstract void dataCallback(ModelType modelType);

    public void errorCallback(Throwable e) {

    }

    public void completeCallback() {

    }
}
