package com.model;

/**
 * Created by akhilg on 14/4/14.
 */
public class FeedMessage {
    String title;
    String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return  "Feed Meassage +" + title +" and Description is " + description;

    }
}
