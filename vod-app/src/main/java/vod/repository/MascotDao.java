package vod.repository;

import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;

import java.util.List;

public interface MascotDao {
    List<Mascot> findAll();
    Mascot findById(int id);
    List<Mascot> findByDesigner(Designer d);
    List<Mascot> findByCompany(Company c);
    Mascot add(Mascot m);
}
