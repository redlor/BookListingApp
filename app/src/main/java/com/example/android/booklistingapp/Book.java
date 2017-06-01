package com.example.android.booklistingapp;

/**
 * Created by Hp on 28/05/2017.
 */

public class Book {

    private String mImage;
    private StringBuilder mAuthor;
    private String mTitle;
    private String mUrl;

    public Book(String image, StringBuilder author, String title, String url) {
        mImage = image;
        mAuthor = author;
        mTitle = title;
        mUrl = url;
    }

    public String getImage() {
        return mImage;
    }

    public StringBuilder getAuthor() {
        return mAuthor;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getUrl() {
        return mUrl;
    }
}
