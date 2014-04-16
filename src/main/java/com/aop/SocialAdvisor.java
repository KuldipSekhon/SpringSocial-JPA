package com.aop;

import com.common.SocialController;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by akhilg on 15/4/14.
 */
public class SocialAdvisor implements MethodBeforeAdvice {

    private SocialAdvice socialAdvice;

    /* Example for Runtime Weaving ***************/
    public void before(Method method, Object[] args, Object target){
        /*********** Specifies the method to implement the AOP on  ***/
        this.socialAdvice.enterSocialMethod();

    }
}
