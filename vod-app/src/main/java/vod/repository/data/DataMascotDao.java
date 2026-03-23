package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;
import vod.repository.MascotDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataMascotDao implements MascotDao {

    private final MascotRepository repository;

    @Override
    public List<Mascot> findAll(){ return repository.findAll(); }
    @Override
    public Mascot findById(int id){ return repository.findById(id).orElse(null); }
    @Override
    public List<Mascot> findByDesigner(Designer d){return repository.findAllByDesigner(d); }
    @Override
    public List<Mascot> findByCompany(Company c){return repository.findAllByCompaniesContaining(c); }
    @Override
    public Mascot add(Mascot m){ return repository.save(m); }
}
