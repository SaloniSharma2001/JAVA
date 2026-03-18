package com.example.sec01;

import java.time.LocalDate;
import java.util.logging.Logger;

//A non canonical constructor is a constructor that does not have the same signature as the default canonical constructor, it can have different parameters and it can also have some logic in it, but it will not override the default canonical constructor, so we can still use the default canonical constructor to create an instance of the record.
public class NonCanonicalConstructor {
    private static final Logger log = Logger.getLogger(NonCanonicalConstructor.class.getName());    

    record Task (String title, LocalDate createdAt){

    }
    public static void main(String[] args) {
        var task = new Task("Create Report", LocalDate.now());
        log.info("Task: " + task);
    }
}
