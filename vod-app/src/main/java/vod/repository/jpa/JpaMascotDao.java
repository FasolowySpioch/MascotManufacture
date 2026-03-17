package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;
import vod.repository.MascotDao;

import java.util.List;
@Repository
@Primary
public class JpaMascotDao implements MascotDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Mascot> findAll() {
        return entityManager.createQuery("select m from Mascot m").getResultList();
    }
    @Override
    public Mascot findById(int id){
        return entityManager.find(Mascot.class, id);
    }
    @Override
    public List<Mascot> findByDesigner(Designer d){
        return entityManager.createQuery("select m from Mascot m where m.designer=:designer")
                .setParameter("designer", d)
                .getResultList();
    }
    @Override
    public List<Mascot> findByCompany(Company c){
        return entityManager.createQuery(
                        "select m from Mascot m inner join m.companies company where company = :company"
                )
                .setParameter("company", c)
                .getResultList();
    }
    @Override
    public Mascot add(Mascot m){
        entityManager.persist(m);
        return m;
    }
}
