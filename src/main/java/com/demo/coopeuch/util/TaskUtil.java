package com.demo.coopeuch.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.demo.coopeuch.entity.Task;

public class TaskUtil {

    public static void crearTaskEntity(Task taskToUpdate, Task updateTask){
        if (checkEmptynullString(String.valueOf(updateTask.getId()))
                && !updateTask.getId().equals(taskToUpdate.getId())){
            taskToUpdate.setId((updateTask.getId()));
        }

    }
    public static boolean checkEmptynullString(String input){
    return !StringUtils.isEmpty(input) && !StringUtils.isEmpty(input.trim());
    }
}
