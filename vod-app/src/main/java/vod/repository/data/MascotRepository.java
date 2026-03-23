package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Mascot;

public interface MascotRepository extends JpaRepository<Mascot, Integer> {
}
