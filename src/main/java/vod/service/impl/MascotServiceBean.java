package vod.service.impl;

import vod.model.Designer;
import vod.model.Mascot;
import vod.repository.CompanyDao;
import vod.repository.DesignerDao;
import vod.repository.MascotDao;
import vod.service.CompanyService;
import vod.service.MascotService;

import java.util.List;
import java.util.logging.Logger;

public class MascotServiceBean implements MascotService {
    private static final Logger log = Logger.getLogger(CompanyService.class.getName());
    private DesignerDao designerDao;
    private MascotDao mascotDao;

    public MascotServiceBean(DesignerDao designerDao, MascotDao mascotDao) {
        log.info("creating mascot service bean");
        this.designerDao = designerDao;
        this.mascotDao = mascotDao;
    }

    @Override
    public List<Mascot> getAllMascots() {
        log.info("searching all mascots");
        return mascotDao.findAll();
    }
    @Override
    public List<Mascot> getMascotByDesigner(Designer d) {
        log.info("searching mascots by designer");
        return mascotDao.findByDesigner(d);
    }
    @Override
    public Mascot getMascotById(int id) {
        log.info("searching mascots by id");
        return mascotDao.findById(id);
    }
    @Override
    public Mascot addMascot(Mascot m) {
        log.info("adding mascot");
        return mascotDao.add(m);

    }
    @Override
    public List<Designer> getAllDesigners() {
        log.info("searching all designers");
        return designerDao.findAll();
    }
    @Override
    public Designer getDesignerById(int id) {
        log.info("searching designers by id");
        return  designerDao.findById(id);
    }
    @Override
    public Designer addDesigner(Designer d) {
        log.info("adding designer");
        return designerDao.add(d);
    }
}
