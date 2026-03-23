package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Designer;

public interface DesignerRepository extends JpaRepository<Designer, Integer> {
}
