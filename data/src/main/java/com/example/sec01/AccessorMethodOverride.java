package com.example.sec01;

import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author Saloni Sharma
 * Accessor Methods are the default provided methods like getter in Record class
 * Record accessor method can be overridden without changing their method signature.
 */
public class AccessorMethodOverride {
    private static final Logger log = Logger.getLogger(AccessorMethodOverride.class.getName());
     record Person(String firstName, String lastName){
         //If we want to add few more validations here we can do that in accessor class
         public String lastName(){
             return this.lastName.toUpperCase();
         }
         
         //This is not possible because we are chaging the method signature.
//         public Optional<String> firstName(){
//             return Optional.ofNullable(this.firstName);
//         }
         
         //Instead that we can introduce some new method
         public Optional<String> firstNameOptional(){
             return Optional.ofNullable(this.firstName);
         }
         
     }
     
     public static void main(String args[]){
         var person = new Person("Saloni","Sharma");
         
         log.info("Person:" + person);
         log.info("Person's Last Name:" + person.lastName());
         
         person.firstNameOptional().orElse("No Name");
     }
    
}
