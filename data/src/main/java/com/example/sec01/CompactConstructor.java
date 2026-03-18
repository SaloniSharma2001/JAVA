package com.example.sec01;

import java.util.logging.Logger;

public class CompactConstructor {
private static final Logger log = Logger.getLogger(CompactConstructor.class.getName());

 record Person(String firstName, String lastName) {

    //Automatically generated constructor in record is called canonical constructor, I am creating one more constructor with same signature, so it will override the default canonical constructor and I can add some logic in it.
    // public Person(String firstName, String lastName) {
    //     this.firstName = firstName;
    //     this.lastName = lastName.toUpperCase();
    // }

    //But the problem is that each time we have to assign all the fields in the constructor if we have 10 fields then we have to assign all 10 fields in the constructor, so to avoid this problem we can use compact constructor, in compact constructor we don't have to assign all the fields, we can just write the logic and it will automatically assign the fields for us.

    //We cannot access this from compact constructor because it is not a static method, so we can directly access the fields without using this keyword.
    // Person {
    //     //This block of code is executed before the default canonical constructor is called, so we can add some logic here to modify the fields after they are assigned by the default constructor. Or we can also add some validation logic here to check the values of the fields before they are assigned by the default constructor.
    //     lastName = lastName.toUpperCase();
    // }

    Person {
        // if (firstName == null || lastName == null) {
        //     throw new IllegalArgumentException("First name and last name cannot be null");
        // }
        // Object.requireNonNull(lastName, "Last name cannot be null");
         if(lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        lastName = lastName.toUpperCase();
    }

}

public static void main(String[] args) {
    
    var person1 = new Person("John", "Doe");
     //var person1 = new Person("John", null);//This will throw an exception because last name cannot be null, so we can add some validation logic in the compact constructor to check the values of the fields before they are assigned by the default constructor. [Exception in thread "main" java.lang.IllegalArgumentException: Last name cannot be null]
    log.info("Person1 Name: " + person1);


}

}
