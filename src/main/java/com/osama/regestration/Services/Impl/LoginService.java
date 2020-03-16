package com.osama.regestration.Services.Impl;

import java.util.HashMap;
import java.util.Map;


import com.osama.regestration.Controller.LoginController;
import com.osama.regestration.Services.Constants;
import com.osama.regestration.Services.Service;
import com.osama.regestration.model.dao.impl.LoginDAOImpl;
import com.osama.regestration.model.dao.impl.StudentDAOImpl;



public class LoginService implements Service {
    LoginController loginController;
    public LoginService(){
        this.loginController=new LoginController(new LoginDAOImpl(),new StudentDAOImpl());
    }
    @Override
    public boolean requireAuthentication() {
        return false;
    }

    @Override
    public Map<String, String> parse(String command) {
        Map<String, String> serviceParams = new HashMap<>();

        String[] param = command.split(" ");
        String studentId = param[1];
        String password = param[2];
        serviceParams.put(Constants.STUDENT_ID.getValue(), studentId);
        serviceParams.put(Constants.PASSWORD.getValue(), password);
        return serviceParams;
    }

    @Override
    public void execute(Map<String, String> params) {
        String studentId=params.get(Constants.STUDENT_ID.getValue());
        String password=params.get(Constants.PASSWORD.getValue());
        loginController.login(studentId,password);
    }
}
