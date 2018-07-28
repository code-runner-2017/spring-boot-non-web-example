package com.pietro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pietro.config.CommandLineOptions;

@Service
public class HelloMessageService {

    @Value("${name:unknown}")
    private String name;
    
    @Autowired
    private CommandLineOptions options;

    public String getMessage() {
        System.out.println("Main parameters="+ options.parameters.toString());
        System.out.println("Verbose="+ options.verbose);
        
        return "Hello Pietro!";
    }

}
