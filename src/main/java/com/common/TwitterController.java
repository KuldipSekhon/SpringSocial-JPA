package com.common;

import javax.inject.Inject;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by akhilg on 16/4/14.
 */

@Controller
@RequestMapping("/tweets")
public class TwitterController {

    private Twitter twitter;

    private ConnectionRepository connectionRepository;

    protected static final Logger logg = Logger.getLogger(TwitterController.class.getName());


    @Inject
    public TwitterController(Twitter twitter,ConnectionRepository connectionRepository){

        this.twitter = twitter;

        this.connectionRepository = connectionRepository;

    }


    @RequestMapping(value="getTweets/",method = RequestMethod.GET)
    public  String getTweets(Model model){

        logg.info("Entered in method getTweets.............................");

        if(connectionRepository.getPrimaryConnection(Twitter.class)==null){
            logg.info("No primary Connection is acheived............................");
            return "redirect:twitter";
        }

        model.addAttribute(twitter.userOperations().getUserProfile());
       // model.addAllAttributes("screen",twitter.userOperations().getScreenName());

        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();

        model.addAttribute("friends",friends);

       logg.info("before returning Model...............");
        return "tweets";


    }




}
