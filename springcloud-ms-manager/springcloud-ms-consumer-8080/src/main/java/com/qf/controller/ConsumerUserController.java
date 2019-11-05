package com.qf.controller;

import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cuser")
public class ConsumerUserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping
    public Object getRemoteUsers() {

        List<User> list = restTemplate.getForObject("http://ms-provider/user", List.class);
        return list;
    }
}
