package com.osama.regestration.Services;

public enum Constants {
    STUDENT_ID("studentId"), PASSWORD("password"), TOKEN("token"), COURSE_ID("courseId");

    private String value;

    Constants(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}