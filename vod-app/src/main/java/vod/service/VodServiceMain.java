package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;
import vod.repository.CompanyDao;
import vod.repository.DesignerDao;
import vod.repository.MascotDao;
import vod.repository.mem.MemCompanyDao;
import vod.repository.mem.MemDesignerDao;
import vod.repository.mem.MemMascotDao;
import vod.service.impl.CompanyServiceBean;
import vod.service.impl.MascotServiceBean;

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
