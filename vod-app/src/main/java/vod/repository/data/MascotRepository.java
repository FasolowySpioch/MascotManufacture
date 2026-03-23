package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;

import java.util.List;

public interface MascotRepository extends JpaRepository<Mascot, Integer> {
    List<Mascot> findAllByDesigner(Designer d);
    List<Mascot> findAllByCompaniesContaining(Company c);
}
