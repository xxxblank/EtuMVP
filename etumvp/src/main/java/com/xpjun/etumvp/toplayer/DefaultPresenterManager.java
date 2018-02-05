package com.xpjun.etumvp.toplayer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rirsa on 2018/2/2.
 */

public class DefaultPresenterManager extends PresenterManager {

    private Map<String,Presenter> presenterMap = new HashMap<>();
    private int nextId;

    @Override
    protected <presenterType extends Presenter> presenterType create(Object view) {
        presenterType presenter = PresenterBuilder.createPresenter(view.getClass());
        String id = getID();
        presenter.id = id;
        presenterMap.put(id,presenter);
        return presenter;
    }

    @Override
    protected void destory(String id) {
        presenterMap.remove(id);
    }

    @Override
    protected <presenterType extends Presenter> presenterType getPresenter(String id) {
        presenterType presenter = (presenterType) presenterMap.get(id);
        return presenter;
    }

    private String getID(){
        return nextId++ + "/" + System.nanoTime() + "/" + (int)(Math.random()*Integer.MAX_VALUE);
    }
}
