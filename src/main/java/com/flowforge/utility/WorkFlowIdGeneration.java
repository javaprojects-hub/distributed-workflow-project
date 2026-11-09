package com.flowforge.utility;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component 
public class WorkFlowIdGeneration {

    private static final SecureRandom RANDOM_NUMBER = new SecureRandom();

    public static String generateWorkflowId() {
       
       int number = RANDOM_NUMBER.nextInt(900_000_000) + 100_000_000;
       
        return "WF" + number;
    }
}
