package com.example.jyhu.runoobandroid.Activities.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by JyHu on 16/8/16.
 */
public class LoadMethod {

    public void Load(String cname, String methodName, String[] types, String[] params) {
        Object mObject = null;
        try {
            Class cls = Class.forName(cname);
            Constructor constructor = cls.getConstructor(null);
            Object object = constructor.newInstance(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
