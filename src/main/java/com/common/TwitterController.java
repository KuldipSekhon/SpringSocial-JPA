package com.common;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionRepositoryException;
import org.springframework.social.twitter.api.*;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.social.connect.Connection;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.social.twitter.api.TwitterProfile;

import javax.inject.Inject;

import java.util.logging.Logger;

/**
 * Created by akhilg on 16/4/14.
 */

@Controller
//@RequestMapping("/tweets")
public class TwitterController extends MultiActionController {

    private final Twitter twitter;

    @Autowired
    private ConnectionRepository connectionRepository;
    protected static final Logger logg = Logger.getLogger(TwitterController.class.getName());

//    @Inject
//    public TwitterController(Twitter twitter,ConnectionRepository connectionRepository){
//        this.twitter = twitter;
//        this.connectionRepository = connectionRepository;
//    }


    @Inject
    public TwitterController(Twitter twitter){
        this.twitter = twitter;
       // this.connectionRepository = connectionRepository;
    }




   @Bean
   @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public Twitter twitter(){

       Connection<Twitter> twitter = connectionRepository.findPrimaryConnection(Twitter.class);

       return  twitter !=null ? twitter.getApi() : new TwitterTemplate();

    }


    @RequestMapping(value="getTweets/",method = RequestMethod.GET)
    public  String getTweets(Model model){

     logg.info("Entered in method getTweets.............................");
        twitter();
//  try {
//      if (connectionRepository.getPrimaryConnection(Twitter.class) == null) {
//          logg.info("No primary Connection is acheived............................");
//          return "redirect:twitter";
//      }
//  }catch (ConnectionRepositoryException e){
//      logg.info("Error----------->>>"+e.getMessage());
//
//  }

        model.addAttribute(twitter.userOperations().getUserProfile());
       // model.addAllAttributes("screen",twitter.userOperations().getScreenName());

        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();

        String screen_name_before = twitter.userOperations().getScreenName();

        String screen_name_after = twitter.userOperations().getScreenName().concat("after_tweeter_api");

        String tweet_from = twitter.timelineOperations().getHomeTimeline().get(6).getFromUser();


        logg.info("Number of freinds are::::::"+friends.get(3).getScreenName()+ "----"+friends.get(2).getName());

        String friend_1= friends.get(5).getProfileImageUrl();

        String fiend_1_name = friends.get(5).getScreenName();

        model.addAttribute("screen_name_before",screen_name_before);

        model.addAttribute("screen_name_after",screen_name_after);

        model.addAttribute("fiend_1_name",fiend_1_name);

        model.addAttribute("friend_1",friend_1);

        model.addAttribute("friends",friends);

        model.addAttribute("tweet_from",tweet_from);


       logg.info("before returning Model...............");
        return "tweets";


    }




}
