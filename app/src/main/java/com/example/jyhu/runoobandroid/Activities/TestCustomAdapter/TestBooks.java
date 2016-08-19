package com.example.jyhu.runoobandroid.Activities.TestCustomAdapter;

/**
 * Created by JyHu on 16/8/19.
 */
public class TestBooks {

    private String bookName;
    private String bookAuthor;

    public TestBooks() {
    }

    public TestBooks(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
