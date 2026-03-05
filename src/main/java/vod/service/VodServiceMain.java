package vod.service;

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
        MascotDao mascotDao = new MemMascotDao();
        CompanyDao companyDao = new MemCompanyDao();
        DesignerDao designerDao = new MemDesignerDao();

        CompanyService serviceCompany = new CompanyServiceBean(companyDao, mascotDao);
        List<Company> companies = serviceCompany.getAllCompanies();

        System.out.println(companies.size() + " companies found:");
        companies.forEach(System.out::println);

        MascotService serviceMascots = new MascotServiceBean(designerDao, mascotDao);
        System.out.println("Let's find all mascots!");

        List<Mascot> mascots = serviceMascots.getAllMascots();
        System.out.println(mascots.size() + " mascots found:");
        mascots.forEach(System.out::println);
    }
}
