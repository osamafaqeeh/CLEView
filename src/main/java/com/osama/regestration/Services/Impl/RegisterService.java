package com.osama.regestration.Services.Impl;
import com.osama.regestration.Controller.RegisterController;
import com.osama.regestration.Services.Authentication;
import com.osama.regestration.Services.Constants;
import com.osama.regestration.Services.Service;
import com.osama.regestration.model.dao.impl.CourseDAOImpl;
import com.osama.regestration.model.dao.impl.ScheduleDAOImpl;
import com.osama.regestration.model.dao.impl.StudentDAOImpl;
import com.osama.regestration.model.entity.Schedule;

import java.util.HashMap;
import java.util.Map;

public class RegisterService implements Service {
    private RegisterController registerController;
    public RegisterService(){
        this.registerController=new RegisterController(new ScheduleDAOImpl(),new CourseDAOImpl(),new StudentDAOImpl());
    }
    @Override
    public Map<String, String> parse(String command) {
        Map<String, String> params = new HashMap<>();
        String[] param = command.split(" ");
        String token = param[1];
        String studentId = param[2];
        String courseId = param[3];

        params.put(Constants.TOKEN.getValue(), token);
        params.put(Constants.STUDENT_ID.getValue(), studentId);
        params.put(Constants.COURSE_ID.getValue(), courseId);
        return params;
    }

    @Override
    public boolean requireAuthentication() {
        return true;
    }


    @Override
    public void execute(Map<String, String> params) {
        Schedule schedule=new Schedule();
        schedule.setIdCourse(params.get(Constants.COURSE_ID.getValue()));
        schedule.setIdStudent(params.get(Constants.STUDENT_ID.getValue()));

    registerController.register(schedule);
    }
}
