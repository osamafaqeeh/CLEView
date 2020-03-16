package com.osama.regestration.Services;

import com.osama.regestration.Controller.AuthenticationController;
import com.osama.regestration.model.dao.LoginDAO;
import com.osama.regestration.model.dao.impl.LoginDAOImpl;

public class AuthenticationUtil {
    private LoginDAOImpl loginDAO;

    public AuthenticationUtil(){
        this.loginDAO=new LoginDAOImpl();

    }

    public  boolean isAuthenticated(String studentId, String token){
        AuthenticationController authenticationController=new AuthenticationController(loginDAO);
        return authenticationController.isAuthenticated(studentId,token);
    }
}


