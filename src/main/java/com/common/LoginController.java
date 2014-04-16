package com.common;

import com.services.UserService;
import com.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

import com.model.User;
import com.dao.UserDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;

/**
 * Created by akhilg on 8/4/14.
 */
@Controller
public class LoginController extends MultiActionController {

    private List<User> users = new LinkedList<User>();

    protected static final Logger logg = Logger.getLogger(LoginController.class.getName());
    private UserDAO userDAO = new UserDAO();
    private UserService userService = new UserServiceImpl();

    private User user = new User();

    @RequestMapping(value = {"/","/LoginController/"}, method = RequestMethod.GET)
    public ModelAndView getUserDetails(HttpServletRequest request, HttpServletResponse response) {
        logg.info("Inside LoginController getUserDetails mathod.........");

     //   String username = request.getParameter("j_username");
    //    String password = request.getParameter("j_password");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username

//
//        ModelMap map = new ModelMap();
//
//        map.addAttribute("username",username);
//
//        map.addAttribute("password",password);
        logg.info("username is::::::"+username);
//     /   logg.info("password is::::::"+password);


        if (username.equals("akkhil2012") /*&& password.equals("12345")*/) {
            ModelAndView modelAndView = new ModelAndView("home");
            modelAndView.addObject("username", username);
         //   modelAndView.addObject("password", password);
            return modelAndView;
        } else {
            return new ModelAndView("reLogin");
        }


    }

    @RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
    public String getUserDetails(ModelMap modelMap) throws java.sql.SQLException
            , ClassNotFoundException {

        users = userDAO.getUserDetails();

        modelMap.addAllAttributes(users);

        return "userDetails";
    }


//    To delete the Specific User:
    //@RequestMapping(value = "/deleteUser/{userID}", method = RequestMethod.GET)
    @RequestMapping(value = "/deleteUser/{userID}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("userID") Integer userID ,  ModelMap modelMap) throws java.sql.SQLException
            , ClassNotFoundException {


       // users = userDAO.getUserDetails();

     //  userService.deleteUser(user.getId());

        userService.deleteUser(userID);

      //  modelMap.addAllAttributes(users);

        return "userDeleted";
    }

    @RequestMapping(value = "/addUser/", method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) throws java.sql.SQLException
            , ClassNotFoundException {


        user.setFirstName((String) request.getParameter("firstname"));

        userDAO.addUser(user);
        /*

        Call to DAO Class to Add User
         */

        map.addAttribute("first Name", user.getFirstName());
        map.addAttribute("Last Name", user.getLastName());
        map.addAttribute("ID", user.getId());
        return "userAdded";
    }


}
