package com.demo.coopeuch.util;

import com.demo.coopeuch.entity.Task;
import com.demo.coopeuch.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.lang.reflect.Array;
import java.util.List;

public class TaskDataInitializer implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {



    }
}
