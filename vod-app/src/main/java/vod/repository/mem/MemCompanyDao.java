package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.model.Company;
import vod.model.Mascot;
import vod.repository.CompanyDao;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemCompanyDao implements CompanyDao {
    @Override
    public List<Company> findAll(){ return SampleData.companies; }
    @Override
    public Company findById(int id){
        return SampleData.companies.stream().filter(company -> company.getId() == id).findFirst().orElse(null);
    }
    @Override
    public List<Company> findByMascot(Mascot m){
        return SampleData.companies.stream().filter(company -> company.getMascotList().contains(m)).collect(Collectors.toList());
    }
}
