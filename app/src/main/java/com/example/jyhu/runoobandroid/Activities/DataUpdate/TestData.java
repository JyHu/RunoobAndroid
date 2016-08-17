package com.example.jyhu.runoobandroid.Activities.DataUpdate;

/**
 * Created by JyHu on 16/8/17.
 */
public class TestData {

    private int imageId;
    private String content;


    public TestData(int imageId, String content) {
        this.imageId = imageId;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
