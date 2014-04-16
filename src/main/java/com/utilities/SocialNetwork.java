package com.utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by akhilg on 11/4/14.
 */
public abstract class SocialNetwork {

      public abstract  void setNext(SocialNetwork socialNetwork);

      //public abstract String access(Social social);
      public abstract String access(Social social,HttpServletRequest request,HttpServletResponse response);
}
