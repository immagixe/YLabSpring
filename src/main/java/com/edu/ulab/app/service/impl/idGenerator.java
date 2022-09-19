package com.edu.ulab.app.service.impl;

import java.util.HashSet;
import java.util.Random;

public class idGenerator {

    private static final Random random = new Random();
    private static final HashSet<Long> bookIds = new HashSet<>();
    private static final HashSet<Long> userIds = new HashSet<>();

    public static Long getNewBookId(){
        long id = Math.abs(random.nextLong());
        while (bookIds.contains(id)){
            id = Math.abs(random.nextLong());
        }
        bookIds.add(id);
        return id;
    }
    public static Long getNewUserId(){
        long id = Math.abs(random.nextLong());
        while (userIds.contains(id)){
            id = Math.abs(random.nextLong());
        }
        userIds.add(id);
        return id;
    }
}
