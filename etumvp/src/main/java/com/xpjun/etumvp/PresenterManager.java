package com.xpjun.etumvp;

/**
 * Created by Rirsa on 2018/2/2.
 */

public abstract class PresenterManager {

    private static volatile PresenterManager manager = null;

    public static PresenterManager getInstance(){
        if (manager == null){
            synchronized (PresenterManager.class){
                if (manager == null){
                    manager = new DefaultPresenterManager();
                }
            }
        }
        return manager;
    }

    protected abstract <presenterType extends Presenter> presenterType create(Object view);
    protected abstract void destory(String id);
    protected abstract <presenterType extends Presenter>presenterType getPresenter(String id);
}
