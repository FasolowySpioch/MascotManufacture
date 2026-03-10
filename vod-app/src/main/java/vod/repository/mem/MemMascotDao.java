package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;
import vod.repository.MascotDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository("mascotDao")
public class MemMascotDao implements MascotDao {
    @Override
    public List<Mascot> findAll(){return SampleData.mascots;}
    @Override
    public Mascot findById(int id) {
        return SampleData.mascots.stream().filter(mascot -> mascot.getId() == id).findFirst().orElse(null);
    }
    @Override
    public List<Mascot> findByDesigner(Designer d) {
        return SampleData.mascots.stream().filter(mascot -> mascot.getDesigner() == d).collect(Collectors.toList());
    }
    @Override
    public List<Mascot> findByCompany(Company c) {
        return SampleData.mascots.stream().filter(mascot -> mascot.getCompanyArrayList().contains(c)).collect(Collectors.toList());
    }
    @Override
    public Mascot add(Mascot m) {
        int max = SampleData.mascots.stream().max((m1,m2)-> m1.getId() - m2.getId()).get().getId() + 1;
        m.setId(max);
        SampleData.mascots.add(m);
        return m;
    }
}
