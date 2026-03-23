package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Company;
import vod.model.Mascot;
import vod.repository.CompanyDao;

import java.util.List;

@Repository
public class JpaCompanyDao implements CompanyDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> findAll(){
        return entityManager.createQuery("select c from Company c").getResultList();
    }
    @Override
    public Company findById(int id){
        return entityManager.find(Company.class, id);
    }
    @Override
    public List<Company> findByMascot(Mascot m){
        return entityManager.createQuery("select c from Company c inner join c.mascotList mascot where mascot=:mascot")
                .setParameter("mascot", m)
                .getResultList();
    }
    @Override
    public Company save(Company c){
        entityManager.persist(c);
        return c;
    }
}
