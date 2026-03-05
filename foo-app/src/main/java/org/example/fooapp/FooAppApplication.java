package org.example.fooapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import vod.service.test.TestService;

@SpringBootApplication
public class FooAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FooAppApplication.class, args);
        //TestService ts = new TestService();
        //System.out.println(ts.hello());
    }

}
