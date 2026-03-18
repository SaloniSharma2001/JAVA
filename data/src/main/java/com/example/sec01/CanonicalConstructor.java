package com.example.sec01;

import java.util.logging.Logger;

public class CanonicalConstructor {
private static final Logger log = Logger.getLogger(CanonicalConstructor.class.getName());

public record Person(String firstName, String lastName) {

    //Automatically generated constructor in record is called canonical constructor, I am creating one more constructor with same signature, so it will override the default canonical constructor and I can add some logic in it.
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName.toUpperCase();
    }

    //But the problem is that each time we have to assign all the fields in the constructor if we have 10 fields then we have to assign all 10 fields in the constructor, so to avoid this problem we can use compact constructor, in compact constructor we don't have to assign all the fields, we can just write the logic and it will automatically assign the fields for us.
}

public static void main(String[] args) {
    var person1 = new Person("John", "Doe");
    log.info("Person1 Name: " + person1);
}

}
