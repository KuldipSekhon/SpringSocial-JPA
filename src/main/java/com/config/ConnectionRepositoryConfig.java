package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionRepository;
//import org.springframework.social.connect.jdbc.JdbcConnectionRepository;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by akhilg on 17/4/14.
 */

@Configuration
public class ConnectionRepositoryConfig {

    protected static final Logger logg = Logger.getLogger(ConnectionRepositoryConfig.class.getName());

    @Autowired
    private Environment environment;

    @Inject
    private DataSource dataSource;




    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator(){

        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        logg.info("before adding the consumer key and  consumer secret");

        try{
        registry.addConnectionFactory(new TwitterConnectionFactory("odvGlDrl0mjZMEmqxsudocKG6","8V8C0wtQH7BRPpikdqyU5HKbGfdLizYklOkZngFGZHP0KnXoZk"));
        }catch (Exception e){
            logg.info("Consumer Keys NOT found........................");
            e.printStackTrace();
        }
//                environment.getRequiredProperty("odvGlDrl0mjZMEmqxsudocKG6"),
//                environment.getRequiredProperty("8V8C0wtQH7BRPpikdqyU5HKbGfdLizYklOkZngFGZHP0KnXoZk")

//        );
                return registry;
     }


    @Bean
    public TextEncryptor textEncryptor(){

        return Encryptors.noOpText();
    }


//    public DataSource getDataSource(){
//
//        Connection connection;
//
//        try
//
//        {
//            connection = dataSource.getConnection("root", "mysql");
//        }catch(SQLException e){
//
//        }
//        return connection;
//    }



    @Bean
    @Scope(value="singleton",proxyMode=ScopedProxyMode.INTERFACES)
    public UsersConnectionRepository usersConnectionRepository() {
        logg.info("prior to getting the User JDBCConnection............");
        return new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator(),
                textEncryptor());
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null)
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");

        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }

    @Bean
    public ConnectController connectController() {
        logg.info("Inside ConnectController.................");
        ConnectController controller = new ConnectController(connectionFactoryLocator(), connectionRepository());
       // controller.setApplicationUrl(environment.getRequiredProperty("application.url"));
        return controller;
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        return filter;
    }


//    @Bean
//    public ConnectionFactoryRegistry connectionFactoryLocator(){
//
//        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
//
//
//        registry.addConnectionFactory(new TwitterConnectionFactory(
//
//                environment.getProperty("twitter.consumerKey"),
//            environment.getProperty("twitter.consumerSecret")
//
//        ));
//
//
//                return registry;
//
//    }
//
//
//    @Inject
//    private Environment environment;



//    @Bean
//    @Scope(value="request", proxyMode= ScopedProxyMode.INTERFACES)
//   public JdbcUsersConnectionRepository connectionRepository(DataSource dataSource, TextEncryptor textEncryptor ,
//                                                             ConnectionFactoryLocator connectionFactoryLocator) {
// //return new JdbcConnectionRepositoy(dataSource, textEncryptor);
//        return new JdbcUsersConnectionRepository(dataSource,connectionFactoryLocator,textEncryptor);
//    }
}
