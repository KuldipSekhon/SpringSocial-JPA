package com.common;

import com.model.Feed;
import com.utilities.*;
import facebook4j.internal.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by akhilg on 11/4/14.
 */
@Controller
public class SocialController {

    private String siteAddress;

    protected static final Logger logg = Logger.getLogger(SocialController.class.getName());

    private Social social = new Social();
    private RSSFeedParser rssFeedParser = new RSSFeedParser("http://timesofindia.feedsportal.com/c/33039/f/533965/index.rss");
    //HttpServletRequest request;
    //HttpServletResponse response;


    @RequestMapping(value="/social/{socialName}")
    public ModelAndView getNetworkSite(@PathVariable("socialName") String socialName, ModelMap map,HttpServletRequest request,
                                       HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView("socialView");


        social.setSocial_name(socialName);
        /*

          CODE TO RETREIVE THE SITE URL USING WEBSERVICES
         */

        SocialNetwork socialNetwork_TW = new TwitterSocial();
        SocialNetwork socialNetwork_FB = new FaceBookSocial();
        SocialNetwork socialNetwork_LKND = new LinkedinSocial();


        socialNetwork_TW.setNext(socialNetwork_FB);
        socialNetwork_FB.setNext(socialNetwork_LKND);

        String socialData = socialNetwork_TW.access(social, request, response);

        logg.info("Getting data for sociallllllllllllll"+socialData);

        modelAndView.addObject("socialData",socialData);

        logg.info("data from Model is==============>>>"+modelAndView.getView());

        return modelAndView;

    }



    @RequestMapping(value="/feeds/{RssFeed_FB}")
    public ModelAndView getRSSFeed(@PathVariable("RssFeed_FB") String socialName, ModelMap map,HttpServletRequest request,
                                       HttpServletResponse response){

        ModelAndView modelAndView = new ModelAndView("RssFeedView");


       String feed = rssFeedParser.readFeed();
       // Feed feed = rssFeedParser.readFeed();

        modelAndView.addObject("rssFeedData",feed);
        logg.info("Got the RSS Feed result............................."+feed.toString());

        return modelAndView;

    }





}
