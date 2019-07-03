package com.trtjk.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TaskService {

    @Async
    public Future<String> doTaskOne() {
        System.out.println("TaskOne start at " + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TaskOne end at " + System.currentTimeMillis());
        return new AsyncResult<String>("111");
    }

    @Async
    public Future<String> doTaskTwo() {
        System.out.println("TaskTwo start at " + System.currentTimeMillis() );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TaskTwo end at " + System.currentTimeMillis() );
        return new AsyncResult<String>("222");
    }

    @Async
    public String doTaskThree() {
        System.out.println("Task3 start at " + System.currentTimeMillis() );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task3 end at " + System.currentTimeMillis() );
        return "333";
    }


}
