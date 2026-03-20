package com.example.sec01;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

//A non canonical constructor is a constructor that does not have the same signature as the default canonical constructor, it can have different parameters and it can also have some logic in it, but it will not override the default canonical constructor, so we can still use the default canonical constructor to create an instance of the record.
public class NonCanonicalConstructor {
    private static final Logger log = Logger.getLogger(NonCanonicalConstructor.class.getName());    

    record Task (String title, LocalDate createdAt){
        
//constructor is not canonical, so it must invoke another constructor of class Task
        Task(String title){
//We cant do something like below
//           this.title=title;
//            this.createdAt = LocalDate.now();

//We have to use one canonical constructor like

        this(title,LocalDate.now());
          }
        }

 
    public static void main(String[] args) {
        //The problem is, callers are forced to give the createdAt timestamp againa nd again even if we are sing java inbuilt method only.
        var task = new Task("Create Report", LocalDate.now());
        //Non canonical constructor comes where we want to give only partial data while initializing the object and object gets created as well.
        log.log(Level.INFO, "Task: {0}", task);
    }
}
