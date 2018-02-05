package com.xpjun.etumvp.toplayer;

/**
 * Created by Rirsa on 2018/2/2.
 * presenter的构造类，通过注解和反射获取presenter对象，使得view层不持有presenter的引用
 */

public class PresenterBuilder {
    public static <presenterType extends
            Presenter> presenterType createPresenter(Class<?> viewType){
        RequirePresenter annotation = viewType.getAnnotation(RequirePresenter.class);
        if (annotation==null){
            return null;
        }
        Class<presenterType> clazz = (Class<presenterType>) annotation.value();
        presenterType presenter = null;
        try {
            presenter = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return presenter;
    }
}
