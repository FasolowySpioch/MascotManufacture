package vod.service;

import vod.model.Designer;
import vod.model.Mascot;

import java.util.List;

public interface MascotService {
    List<Mascot> getAllMascots();
    List<Mascot> getMascotByDesigner(Designer d);

    Mascot getMascotById(int id);
    Mascot addMascot(Mascot m);

    List<Designer> getAllDesigners();
    Designer getDesignerById(int id);
    Designer addDesigner(Designer d);
}
