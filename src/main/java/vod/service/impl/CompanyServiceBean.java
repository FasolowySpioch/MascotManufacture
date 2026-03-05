package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vod.model.Company;
import vod.model.Mascot;
import vod.repository.CompanyDao;
import vod.repository.MascotDao;
import vod.service.CompanyService;

import java.util.List;
import java.util.logging.Logger;

@Component
public class CompanyServiceBean implements CompanyService {
    private static final Logger log = Logger.getLogger(CompanyService.class.getName());

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private MascotDao mascotDao;

    @Autowired
    public void setCompanyDao(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }
    @Autowired
    public void setMascotDao(MascotDao mascotDao) {
        this.mascotDao = mascotDao;
    }

    public CompanyServiceBean(CompanyDao companyDao, MascotDao mascotDao){
        log.info("creating company service bean");
        this.companyDao = companyDao;
        this.mascotDao = mascotDao;
    }
    @Override
    public Company getCompanyById(int id) {
        log.info("searching companies by id "+id);
        return companyDao.findById(id);
    }
    @Override
    public List<Company> getAllCompanies() {
        log.info("searching all companies");
        return companyDao.findAll();
    }
    @Override
    public List<Company> getCompaniesByMascots(Mascot m) {
        log.info("searching companies by mascot");
        return companyDao.findByMascot(m);
    }
    @Override
    public List<Mascot> getMascotsByCompany(Company c) {
        log.info("searching mascots by company");
        return mascotDao.findByCompany(c);
    }
}
