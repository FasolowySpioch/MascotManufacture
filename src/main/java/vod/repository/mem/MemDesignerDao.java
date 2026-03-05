package vod.repository.mem;

import vod.model.Designer;
import vod.repository.DesignerDao;

import java.util.List;

public class MemDesignerDao implements DesignerDao {
    @Override
    public List<Designer> findAll(){ return SampleData.designers; }
    @Override
    public Designer findById(int id) {
        return SampleData.designers.stream().filter(designer -> designer.getId() == id).findFirst().orElse(null);
    }
    @Override
    public Designer add(Designer d) {
        int max = SampleData.designers.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.designers.add(d);
        return d;
    }
}
