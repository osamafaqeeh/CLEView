package com.osama.regestration.Services.Impl;

import com.osama.regestration.Services.Service;

import java.util.Map;

public class ListService implements Service {
    @Override
    public boolean requireAuthentication() {
        return false;
    }

    @Override
    public Map<String, String> parse(String command) {
        return null;
    }

    @Override
    public void execute(String command) {

    }
}
