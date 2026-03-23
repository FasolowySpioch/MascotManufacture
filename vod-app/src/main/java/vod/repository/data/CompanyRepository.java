package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Company;
import vod.model.Mascot;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findAllByNameContaining(String name);

    @Query("select c from Company c inner join c.mascotList mascot where mascot=:mascot")
    List<Company> findAllByMascotList(@Param("mascot") Mascot mascot);
}
