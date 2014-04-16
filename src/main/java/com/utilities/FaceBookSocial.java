package com.utilities;


import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.conf.ConfigurationBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;


/**
 * Created by akhilg on 11/4/14.
 */
public class FaceBookSocial extends SocialNetwork {

    private SocialNetwork socialNetwork;
    private URL url;



    protected static final Logger logg = Logger.getLogger(FaceBookSocial.class.getName());

    @Override
    public void setNext(SocialNetwork socialNetwork) {

        this.socialNetwork = socialNetwork;
    }

    @Override
    public String access(Social social,HttpServletRequest request, HttpServletResponse response
                         ) {


        logg.info("Inside access ************");
        Facebook facebook=null;
        if(social.getSocial_name().equals("FaceBook")){
            logg.info("After social check...........................>>>>>");
            try {
                facebook = new FacebookFactory().getInstance();
                facebook.setOAuthAppId("", "");
               // String accessTokenString = "CAACEdEose0cBAJGw4DiDyq7uxC6HnUMfxfQ7wPd4avNRVA03c1qM4n7zdCubtZBYwqnJoWBEOVsJuEosHJ9rpKpbVcbxcTLgCfOUcnpVasfjYsTOaFWGmYH68lWhBdOTWtiZAYlpopFfi3wjsQIngyYwRqPLgdj5WXdb2rBxesMghIzRCNNPKjC66aNZBaMvg2B7ZCAPjgZDZD";
                String accessTokenString = "CAACEdEose0cBAHEomN5EnDDfepiQEIFJYyPqNFrJwHZBDiBoY2wY9TjiXVmYhKUWmOeJCZAVa1HMMkcpesr1oMywXcyAKstmtW60a14njw8rZBSNATod850QOD1ZAkYU3UJbVKTchzj9VcBr7ZCGrE3nm36D8RPB6lJrYyax5dh6jzoVrOC9QX3hmRy3pGYUc4yiX4sVHWgZDZD";
                AccessToken at = new AccessToken(accessTokenString);
                facebook.setOAuthAccessToken(at);
                facebook.postStatusMessage("Just for testing purpose.......CASE New 3");
                logg.info("After setting the AOuth Token for user profile................................"+facebook.getName());
            }catch (Exception ex){
                ex.printStackTrace();
            }
            facebook4j.auth.AccessToken accessToken = facebook.getOAuthAccessToken();
            logg.info("Access token is::: "+accessToken);
            /*
try {
    logg.info("Face book instance......" + facebook.getName());
}catch (FacebookException e){
    logg.info("exception while getting FB instace is........... "+e.getErrorMessage());
}
            request.getSession().setAttribute("facebook", facebook);
            StringBuffer callbackURL = request.getRequestURL();
            int index = callbackURL.lastIndexOf("/");
            callbackURL.replace(index, callbackURL.length(), "").append("/callback");
            try {
                facebook.postStatusMessage("FIRST MESSAGE ON FACEBOOK WALL");
            }
            catch (FacebookException e) {
              logg.info("Face Book exception while posting is>>>>>"+e.getErrorMessage());
            }
            try {
                response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
            }catch (IOException ex){

            }
            /*
            try {
                logg.info("Inside Try block.................@@@@..........");
                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true)
                        .setOAuthAppId("25554907596")
                        .setOAuthAppSecret("12345")
                        .setOAuthAccessToken("12345")
                        .setOAuthPermissions("email,publish_stream,...");
                logg.info("Configuration is::::::::::"+cb.getClass().getName());
                FacebookFactory ff = new FacebookFactory(cb.build());
                logg.info("FaceBook factory................"+ff.getClass().getName());
                try {
                    facebook = ff.getInstance();
                    facebook.getName();
                }catch (FacebookException ex)
                {
                    logg.info("Exception while initializing the connection to FB :)"+ ex.getErrorMessage());

                    logg.info("Is this caused by network issue........."+ex.isCausedByNetworkIssue());
                    logg.info("Is this due to resource NOT Found:::::::"+ex.resourceNotFound());
                }


                logg.info("FaceBook instance is-------->"+facebook.getName());
                logg.info("Name"+facebook.getName());
                logg.info("ID"+facebook.getId());
                logg.info("token"+facebook.getOAuthAccessToken());
                logg.info("Accounts"+facebook.getAccounts());
                facebook.postStatusMessage("Hello World from Facebook4J implementation in my App...");


               try{

                   logg.info("after getting =facebook instance");
                   facebook.getOAuthAppAccessToken();
                   return facebook.toString();
               }catch (FacebookException ex){
                   ex.getStackTrace();
               }



             //   url = new URL("https://www.facebook.com/index.html");

//                try {
//                    logg.info("AFter getting FaceBook Connection..************");
//                    URLConnection url_connect = url.openConnection();
//                    logg.info("Obtaining connection-----------"+url_connect.toString());
//
//                    BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(url_connect.getInputStream()));
//                    String inputLine;
//                    while ((inputLine = bufferedReader.readLine()) != null) {
//                        logg.info("DATA RETREIVED IS=============="+inputLine);
//                        return inputLine;
//                    }
//                    bufferedReader.close();
//
//                }catch (IOException e){
//
//                }
            }catch (Exception ex){
                ex.getStackTrace();
            }
        */
        }else{
            socialNetwork.access(social, request, response);
        }

         return "";

    }
}
