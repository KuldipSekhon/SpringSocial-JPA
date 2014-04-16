package com.jpa.twitter;

/**
 * Created by akhilg on 16/4/14.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.social.UserIdSource;
//import org.springframework.social.config.annotation.EnableInMemoryConnectionRepository;
//import org.springframework.social.connect.ConnectionFactoryLocator;
//import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
//import org.springframework.social.twitter.config.annotation.EnableTwitter;


@Configuration
//@EnableTwitter(appId="odvGlDrl0mjZMEmqxsudocKG6", appSecret="8V8C0wtQH7BRPpikdqyU5HKbGfdLizYklOkZngFGZHP0KnXoZk")
// Access token: 1597644001-2BKdUfpowjlO5iHQABgMPHt2F00bVfJFBE2vlMJ
// ACcess Secret: CxZ5TzSHGXlVfoyPuHOcoFwGL23U2vXlohvqwySTW2iWn
public class TwitterConfig {

    private static Twitter twitter;

    public TwitterConfig(){

        if(twitter==null){
            twitter
            = new TwitterTemplate("odvGlDrl0mjZMEmqxsudocKG6", "8V8C0wtQH7BRPpik**********FGZHP0KnXoZk",
                    "1597644001-2BKd*****************F00bVfJFBE2vlMJ", "CxZ5TzSHGXlVf******8wySTW2iWn");
        }

    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Twitter twitter() {
        return twitter;
    }




}
