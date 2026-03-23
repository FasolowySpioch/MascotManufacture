package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Designer;
import vod.repository.DesignerDao;

import java.util.List;
@Repository
@RequiredArgsConstructor
@Primary
public class DataDesignerDao implements DesignerDao {
    private final DesignerRepository repository;

    @Override
    public List<Designer> findAll(){ return repository.findAll(); }
    @Override
    public Designer findById(int id){ return repository.findById(id).orElse(null); }
    @Override
    public Designer add(Designer d){ return  repository.save(d); }
}
