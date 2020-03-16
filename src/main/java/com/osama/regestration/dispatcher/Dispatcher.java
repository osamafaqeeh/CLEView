package com.osama.regestration.dispatcher;

import com.osama.regestration.Services.AuthenticationUtil;
import com.osama.regestration.Services.Constants;
import com.osama.regestration.Services.Service;

import java.util.Map;

public class Dispatcher {



    public void dispatcher(String line){

        String serviceName = line.split(" ")[0];
        Service service = ServiceLocator.getController(serviceName);
        if(service == null) {
            throw new UnsupportedOperationException(serviceName + " - is Not Supported");
        }
        Map<String, String> params = service.parse(line);
        if(service.requireAuthentication()) {
            AuthenticationUtil authenticationUtil=new AuthenticationUtil();
                boolean authentication=authenticationUtil.isAuthenticated(params.get(
                            Constants.STUDENT_ID.getValue()), params.get(Constants.TOKEN.getValue()));
                    if (authentication){
                        service.execute(params);
                    }
                    else {
                        new RuntimeException("NO authentication");
                    }
        }

    }
}
