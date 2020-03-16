package com.osama.regestration.dispatcher;

import com.osama.regestration.Services.Impl.ListService;
import com.osama.regestration.Services.Impl.LoginService;
import com.osama.regestration.Services.Impl.RegisterService;
import com.osama.regestration.Services.Impl.SignUpService;
import com.osama.regestration.Services.Service;

import java.util.HashMap;

public class ServiceLocator {
   private static final HashMap<String, Service>controllers;
    static {

        controllers=new HashMap<>();

        controllers.put("login",new LoginService());
        controllers.put("sign up",new SignUpService());
        controllers.put("list",new ListService());
        controllers.put("register",new RegisterService());

    }

    public static Service getController(String command){

        return controllers.get(command);

    }

}
