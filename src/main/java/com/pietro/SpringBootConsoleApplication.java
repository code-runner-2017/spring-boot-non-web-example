package com.pietro;

import static java.lang.System.exit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.beust.jcommander.JCommander;
import com.pietro.config.CommandLineOptions;
import com.pietro.service.HelloMessageService;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

    @Autowired
    private HelloMessageService helloService;
    
    @Autowired
    private CommandLineOptions options;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        JCommander jCommander = new JCommander(options);
        jCommander.parse(args);
        
        if (!options.validate() || options.showHelp) {
            jCommander.usage();
            System.exit(1);            
        }
        
        System.out.println(helloService.getMessage());

        exit(0);
    }
}