package vod.web.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloRest {
    @GetMapping("/hello")
    String sayHello() {return "Hello World!"; }
}
