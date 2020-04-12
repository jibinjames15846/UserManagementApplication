package com.jibinmicroservice.usermanagement.actuatorEndPoint;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
@Component
@Endpoint(id = "userAppInfo")

public class UserAppInfoEndPoint {

    @ReadOperation
    public UserAppInfo userAppInfo()
    {
        Map<String,Object> details = new LinkedHashMap<>();
        details.put("App Location ","Chalakudy");
        details.put("Status","Reporting from chalakudy.  All Good");
        UserAppInfo health = new UserAppInfo();
        health.setHealthDetails(details);
        return  health;

    }

    @ReadOperation
    public String userAppEndPointByName(@Selector String name)
    {
        return  " This is user Management Application reporting from chalakudy All Okey  ";
    }

    @WriteOperation
    public void writeOperation(@Selector String name)
    {
        // perform write operation
    }

    @DeleteOperation
    public  void deleteOperation(@Selector String name)
    {
        // perform delete operation
    }

}
