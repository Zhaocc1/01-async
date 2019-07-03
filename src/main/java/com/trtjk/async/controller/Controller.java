package com.trtjk.async.controller;

import com.trtjk.async.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class Controller {

    @Autowired
    private TaskService taskService;

    @GetMapping("test")
    public String test() throws ExecutionException, InterruptedException {

        System.out.println("test start at " + System.currentTimeMillis());
        Future<String> s1 = taskService.doTaskOne();
        Future<String> s2 = taskService.doTaskTwo();
       // String s3 = taskService.doTaskThree();
        System.out.println(s1.get());
        System.out.println("test end at " + System.currentTimeMillis());
        return s1.get()+s2.get() + ":" + System.currentTimeMillis();
    }


}
