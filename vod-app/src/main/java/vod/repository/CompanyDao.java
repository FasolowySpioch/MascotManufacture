package vod.repository;

import vod.model.Company;
import vod.model.Mascot;

import java.util.List;

public interface CompanyDao {
    List<Company> findAll();
    Company findById(int id);
    List<Company> findByMascot(Mascot m);
}
