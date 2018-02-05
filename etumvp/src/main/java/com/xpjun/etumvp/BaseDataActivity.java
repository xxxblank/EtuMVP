package com.xpjun.etumvp;

import com.xpjun.etumvp.toplayer.Presenter;
import com.xpjun.etumvp.viewlayer.BaseActivity;

/**
 * Created by Rirsa on 2018/2/5.
 */

public abstract class BaseDataActivity<PresenterType extends Presenter,ModelType>
        extends BaseActivity<PresenterType> {

    public abstract void dataCallback(ModelType modelType);

    public void errorCallback(Throwable t) {

    }

    public void completeCallback() {

    }
}
