package com.utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by akhilg on 11/4/14.
 */
public class LinkedinSocial extends SocialNetwork{

    private SocialNetwork socialNetwork;
    HttpServletRequest request;
    HttpServletResponse response;

    @Override
    public void setNext(SocialNetwork socialNetwork) {
        this.socialNetwork = socialNetwork;
    }


    public String access(Social social,HttpServletRequest request,HttpServletResponse response) {
        if(social.getSocial_name().equals("Linkedin")){

        }else{
            socialNetwork.access(social,request,response);
        }
        return "";

    }

}
