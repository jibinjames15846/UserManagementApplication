package com.jibinmicroservice.usermanagement.controller;

import com.jibinmicroservice.usermanagement.dto.User;
import com.jibinmicroservice.usermanagement.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    Logger log = LoggerFactory.getLogger("userManagementApp");


    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllusers()
    {
        log.info("Getting All Users ");
       return   userService.getAllUsers();

    }


    @GetMapping("/user/{id}")
    public  User getUser(@PathVariable String id)
    {
        return  userService.getUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user)
    {
        userService.addUser(user);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }


    @PutMapping("/user")
    public User updateUser(@RequestBody User user)
    {
       return userService.updateUser(user);

    }

   @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable  String id)
    {
      return   userService.deleteUser(id);
    }
    @GetMapping("/logs")
    public String logs()
    {
        log.trace("A TRACE message");
        log.debug("A DEBUG message");
        log.info(" A INFO message");
        log.warn(" A WARNING message");
        log.error(" A ERROR message");
         return  " This is a logger method by jibin ";

    }

}
