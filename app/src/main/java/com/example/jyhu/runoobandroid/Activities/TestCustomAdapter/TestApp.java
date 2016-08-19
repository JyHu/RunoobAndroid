package com.example.jyhu.runoobandroid.Activities.TestCustomAdapter;

/**
 * Created by JyHu on 16/8/19.
 */
public class TestApp {
    private String appName;
    private int appIcon;

    public TestApp() {
    }

    public TestApp(String appName, int appIcon) {
        this.appName = appName;
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(int appIcon) {
        this.appIcon = appIcon;
    }
}
