package com.appsdeveloperblog.app.ws.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class MyUtils {
    public String generrateMyUserID() {
        return UUID.randomUUID().toString();
    }
}
