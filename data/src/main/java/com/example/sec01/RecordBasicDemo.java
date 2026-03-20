package com.example.sec01;

import java.util.logging.Logger;

public class RecordBasicDemo {
private static final Logger log = Logger.getLogger(RecordBasicDemo.class.getName());

public record Person(String firstName, String lastName) {
    //We cannot sneak in and extra field inside the record later, it should be declared as the record component if it belong to a record.
    //Will not work. 
    //private String middleName;
    
    //But we can add instance methods like
    public String fullName(){
        return this.firstName + " " + this.lastName;
    }
}

public static void main(String[] args) {
    //var person = new Person("John", "Doe");
    Person person1 = new Person("John", "Doe");
    Person person2 = new Person("John", "Doe");
    Person person3 = new Person("alice", "bob");

    log.info("Person1 Name: " + person1.firstName() + " " + person1.lastName());
    log.info("Person2 Name: " + person2.firstName() + " " + person2.lastName());
    log.info("Person3 Name: " + person3.firstName() + " " + person3.lastName());

    log.info("Person1 to String: " + person1.toString());
    log.info("Person2 to String: " + person2.toString());
    log.info("Person3 to String: " + person3.toString());

    log.info("Person1 hashCode: " + person1.hashCode());
    log.info("Person2 hashCode: " + person2.hashCode());
    log.info("Person3 hashCode: " + person3.hashCode());

    log.info("person1 == person2: " + (person1 == person2));
    log.info("Person2 == person3: " + (person2 == person3));
    log.info("Person3 == person1: " + (person3 == person1));

}

}