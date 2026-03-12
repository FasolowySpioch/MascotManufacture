package vod.service;

import vod.model.Company;
import vod.model.Mascot;

import java.util.List;

public interface CompanyService {
    Company getCompanyById(int id);
    List<Company> getAllCompanies();
    List<Company> getCompaniesByMascots(Mascot m);
    List<Mascot> getMascotsByCompany(Company c);
    Company addCompany(Company c);

}
