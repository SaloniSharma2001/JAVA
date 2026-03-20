
package com.example.sec01;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Saloni Sharma
 * Records are shallowly immutable. It depends.
 * Record components are final. But that does not guarantee immutability.
 * A record is truly immutable only if all of its components are immutable.
 */
public class ImmutableRecord {
     private static final Logger log = Logger.getLogger(ImmutableRecord.class.getName());
    
//     record Team(String name, List<String> members){
//     }
     
     //Record with compact constructor to avoid mutability
     record Team(String name, List<String> members){
         Team{
             //Since we have already made a copy of the value used in initializing the object of record class, we have avoided the direct reference of the list type.
             //As this constructor will be used for initialization and the copy of provided value will be assign to the members. In later case if the list provided is changed it won't affect the copy part.
             members = List.copyOf(members);
         }
     }
     
    public static void main(String args[]){
        var members = new ArrayList<String>();
        members.add("Saloni");
        members.add("Sayan");
        members.add("Ani Da");
        members.add("Debjit");
        
        var team = new Team("Kiddo FC", members);
        log.log(Level.INFO, "Team: {0}", team); //Team: Team[name=Kiddo FC, members=[Saloni, Sayan, Ani Da, Debjit]]
                members.add("Joydeep");
        log.log(Level.INFO, "Team: {0}", team); // Team: Team[name=Kiddo FC, members=[Saloni, Sayan, Ani Da, Debjit, Joydeep]]
        
        //Based on the output we can say that above record have mutable list and hence record is mutable in here as well.
        //We can use compact constructor just to make sure that the provided type is immutable so that record remains immutable.
        //Every time we want to record fully immutable, it is the developer's responsibility to add the requrired check.
    }
}
