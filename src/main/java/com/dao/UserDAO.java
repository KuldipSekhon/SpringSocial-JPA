package com.dao;

import com.model.User;
import com.sun.java.util.jar.pack.*;


import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import java.sql.DriverManager;
import java.util.logging.Logger;

/**
 * Created by akhilg on 8/4/14.
 */
public class UserDAO {

    protected static final Logger logg = Logger.getLogger(UserDAO.class.getName());

    private DataSource source;
    private Set users = new HashSet();

    private static String URL_CONNECTION="jdbc:mysql://localhost:3306/Users";
    private static String USERNAME="root";
    private static String PASSWORD="mysql";

    private int id;
    private String firstname;
    private String lastname;


    private  boolean result;

    Connection conn = null;
    PreparedStatement preparedStatement;

    Statement statement;


    DriverManager driverManager;



    //conn = DriverManager.getConnection(URL_CONNECTION,USERNAME,PASSWORD);





   public List<User> getUserDetails() throws  java.sql.SQLException,java.lang.ClassNotFoundException{
       /*

       SQL statement to retreive user details
        */

        User user = null;

       Class.forName("com.mysql.jdbc.Driver");
       logg.info("After getting the JDBC Driver........................."+URL_CONNECTION+"-------"+USERNAME+"----------"+
       PASSWORD);

       conn = DriverManager.getConnection(URL_CONNECTION,USERNAME,PASSWORD);

      // statement = conn.createStatement();

        String getUserDetails="SELECT * FROM User";

       statement = conn.createStatement();

       logg.info("Value for prepared statement execution is.................."+preparedStatement.executeQuery());

       ResultSet resultSet = (ResultSet)statement.executeQuery(getUserDetails);

     //  ResultSet resultSet = statement.executeQuery("SELECT * FROM User");

       logg.info("Statement formed......==========>>>>>>>>>>>>>>>........."+resultSet.getFetchSize());

       List<User> userList = new LinkedList<User>();

     //  logg.info("Before iterating ResultSet..."+resultSet.getString(firstname));
       while(resultSet.next()){
           user.setFirstName(resultSet.getString(firstname));
           user.setLastName(resultSet.getString(lastname));
           user.setId(Integer.valueOf(resultSet.getString(id)));
           userList.add(user);
       }
       preparedStatement.close();

       conn.close();

       return  userList;
   }



    public void addUser(User user) throws  java.sql.SQLException,java.lang.ClassNotFoundException{

         /*

       SQL statement to ADD user details
        */
        Class.forName("com.mysql.jdbc.Driver");
        logg.info("After getting the JDBC Driver");

        conn = DriverManager.getConnection(URL_CONNECTION,USERNAME,PASSWORD);

        String addUser = "INSERT INTO User values(?,?,?)";
        logg.info("FIRST NAME"+user.getFirstName());

        preparedStatement = conn.prepareStatement(addUser);


        preparedStatement.setString(1,user.getFirstName());
        preparedStatement.setString(2,user.getLastName());
        preparedStatement.setInt(3,user.getId());



        preparedStatement.execute();

        preparedStatement.close();

        conn.close();
    }


    public boolean deleteUser(int id) throws  java.sql.SQLException,java.lang.ClassNotFoundException{



        Class.forName("com.mysql.jdbc.Driver");
;

        conn = DriverManager.getConnection(URL_CONNECTION,USERNAME,PASSWORD);

        // statement = conn.createStatement();

        String deleteUser="DELETE FROM User WHERE id=?";

        logg.info("About to delete User ID..........................");

        preparedStatement = conn.prepareStatement(deleteUser);

        preparedStatement.setInt(1,id);

        logg.info("ID being set to be deleted is ::::"+id);

        result =  preparedStatement.execute();

        logg.info("After deletion of User ID.........................."+result);

        preparedStatement.close();

        return  result;

       // return true;

    }



//    public User getUserCredentials() throws  java.sql.SQLException,java.lang.ClassNotFoundException{
//
//        Class.forName("com.mysql.jdbc.Driver");
//
//        conn = DriverManager.getConnection(URL_CONNECTION,USERNAME,PASSWORD);
//
//        String getUserCredentials = "SELECT * FROM  Users";
//
//        user.
//
//
//    }




}
