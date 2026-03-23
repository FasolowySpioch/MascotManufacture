package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Company;
import vod.model.Mascot;
import vod.repository.CompanyDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataCompanyDao implements CompanyDao {

    private final CompanyRepository repository;

    @Override
    public List<Company> findAll(){ return repository.findAll(); }
    @Override
    public Company findById(int id){ return repository.findById(id).orElse(null); }
    @Override
    public List<Company> findByMascot(Mascot m){ return repository.findAllByMascotList(m); }
    @Override
    public Company save(Company c){ return repository.save(c);}
}