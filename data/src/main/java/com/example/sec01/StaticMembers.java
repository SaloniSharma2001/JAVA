package com.example.sec01;

import java.util.logging.Logger;

/**
 *
 * @author Saloni Sharma
 */
public class StaticMembers {
    private static final Logger log = Logger.getLogger(StaticMembers.class.getName());
    
    record Price(double amount, String currency){
        //In records we cannot have private instance members but we can have static instance members and we dont have problem with that.
        
        private static final String USD = "$";
        
        //And we can have static factory methods like
        static Price usd(double amount){
            return new Price(amount, USD);
        }
    }
    
    public static void main(String args[]){
        log.info("USD:" + Price.usd(10.50));
    }
    
}
