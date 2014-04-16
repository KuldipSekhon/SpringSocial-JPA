package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akhilg on 14/4/14.
 */
public class Feed {

    final String title;

    final String description;

    final List<FeedMessage> entries = new ArrayList<FeedMessage>();




    public Feed(String title,String description){

        this.title = title;
        this.description = description;


    }





}
