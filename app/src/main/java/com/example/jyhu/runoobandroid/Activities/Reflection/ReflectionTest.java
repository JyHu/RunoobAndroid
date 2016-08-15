package com.example.jyhu.runoobandroid.Activities.Reflection;

import android.net.wifi.p2p.WifiP2pManager;

import java.io.Serializable;

/**
 * Created by JyHu on 16/8/15.
 */
public class ReflectionTest extends Object implements Serializable, WifiP2pManager.ActionListener {
    private int bint;
    public Integer binteger = new Integer(4);
    public String strb = "crazypebble";
    private String stra;

    public ReflectionTest() {

    }

    protected ReflectionTest(int id, String name) {

    }

    public int abc(int id, String name) {
        System.out.println("crazy pebble --> " + id + " - " + name);
        return 0;
    }

    protected static void edf() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(int i) {

    }
}
