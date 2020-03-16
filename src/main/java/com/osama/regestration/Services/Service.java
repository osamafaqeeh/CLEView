package com.osama.regestration.Services;

import java.util.Map;

public interface Service {
    boolean requireAuthentication();

    Map<String, String> parse(String command);

    void execute(Map<String, String> params);
}
