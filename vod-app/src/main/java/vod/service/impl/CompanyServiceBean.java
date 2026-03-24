package vod.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Company;
import vod.model.Mascot;
import vod.repository.CompanyDao;
import vod.repository.MascotDao;
import vod.service.CompanyService;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CompanyServiceBean implements CompanyService {
    private static final Logger log = Logger.getLogger(CompanyService.class.getName());

    @Autowired //<= I am not sure if any autowire is correct really
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
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public Company addCompany(Company c){
        log.info("adding new company");
        return companyDao.save(c);
    }
}
