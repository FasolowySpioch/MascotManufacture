package vod;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Company;
import vod.service.CompanyService;

import java.util.List;


public class VodServiceMain {
    public static void main(String[] args){
        System.out.println("Let's find all companies!");
        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        CompanyService service = context.getBean(CompanyService.class);
        List<Company> companies = service.getAllCompanies();
        System.out.println(companies.size() + " companies found:");
        companies.forEach(System.out::println);
    }
}
