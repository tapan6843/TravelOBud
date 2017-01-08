package com.org.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jatan on 1/7/2017.
 */
@RestController
public class IndexController {

    public final static String GREETING = "Make travel a fun game!";

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return GREETING;
    }
}
