package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.model.Company;
import vod.model.Mascot;
import vod.repository.CompanyDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository("companyDao")
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
    @Override
    public Company save(Company company){
        int maxId = SampleData.companies.stream().sorted((c1,c2)->c1.getId()-c2.getId()).findFirst().
                map(c->c.getId()).orElse(0);
        company.setId(maxId+1);
        SampleData.companies.add(company);
        return company;
    }
}
