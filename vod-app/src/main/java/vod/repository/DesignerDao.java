package vod.repository;

import vod.model.Designer;

import java.util.List;

public interface DesignerDao {
    List<Designer> findAll();
    Designer findById(int id);
    Designer add(Designer d);
}
