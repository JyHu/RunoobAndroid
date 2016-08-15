package com.example.jyhu.runoobandroid;

/**
 * Created by JyHu on 16/8/14.
 */
public class RATesting {

    private String testName;
    private String activityName;
    private String testDetail;

    public RATesting() {
        this.testName = "";
        this.activityName = "";
        this.testDetail = "";
    }

    public RATesting(String tname, String aname) {
        this.testName = tname;
        this.activityName = aname;
        this.testDetail = "";
    }

    public RATesting(String tname, String aname, String detail) {
        this.testName = tname;
        this.activityName = aname;
        this.testDetail = detail;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getTestDetail() {
        return testDetail;
    }

    public void setTestDetail(String testDetail) {
        this.testDetail = testDetail;
    }
}
