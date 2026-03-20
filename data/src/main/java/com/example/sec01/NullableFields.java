package com.example.sec01;

import java.util.Optional;
import java.util.logging.Logger;

/**
 *
 * @author Saloni Sharma
 * Records are data carriers, and their fields can be null.
 * If we want to prevent null, we can use a compact constructor to validate the fields
 * or use Optional to make it explicit.
 */
public class NullableFields {
    private static final Logger log = Logger.getLogger(NullableFields.class.getName());
    
//    record Person(String name, String nickName){
//        //In this case, not everyone will have a nick name so it is optional
//    }
        record Person(String name, Optional<String> nickName){
        //In this case, we will have to provide nickName covered with Optional inorder to use canonical constructor.
            
        //We can make use of non canonical constructor in case we are going to and empty nickName and we can also make a Compact Constructor which will wrap the provided nickName in Optional for us.
            
            Person(String name){
                this(name, Optional.empty());
            }
            
             Person(String name, String nickName){
                this(name, Optional.ofNullable(nickName));
            }
    }
    
    public static void main(String args[]){
        
        var sal = new Person("Saloni", Optional.ofNullable("Sharma"));
        //var Rosh = new Person("Roshni", Optional.empty()); Upon introduction of non canonical constructor
        var Rosh = new Person("Roshni");
        //Now we don't need to make Raghu as optional.
        var Rag = new Person("Raghav", "Raghu");
        
    }
    
    //Optional as paramter is discouraged in Java, why?
    //Because while calling this method each string is supposed to be covered in Optional
//    public static void test(Optional<String> value){
//        
//    }
    
    public static void test(String val){
        Optional.ofNullable(val);
    }
    
}
