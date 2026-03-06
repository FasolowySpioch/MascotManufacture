package vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Company;
import vod.service.CompanyService;

import java.util.List;

@SpringBootApplication
public class VodServiceMain {
    public static void main(String[] args){
        SpringApplication.run(VodServiceMain.class, args);
    }
}
