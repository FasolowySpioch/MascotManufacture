package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vod.model.Company;
import vod.model.Designer;
import vod.model.Mascot;
import vod.service.CompanyService;
import vod.service.MascotService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MascotController {
    private final MascotService mascotService;
    private final CompanyService companyService;

    @GetMapping("/mascots")
    String getMascots(Model model, @RequestParam(value = "companyId", required = false) Integer companyId, @RequestParam(value = "designerId", required = false) Integer designerId, RedirectAttributes redirectAttributes){
        if(companyId!=null){
            Company company = companyService.getCompanyById(companyId);
            List<Mascot> mascots = companyService.getMascotsByCompany(company);
            model.addAttribute("mascots", mascots);
            model.addAttribute("title", "Mascots");
        }
        else if(designerId!=null){
            Designer designer = mascotService.getDesignerById(designerId);
            List<Mascot> mascots = mascotService.getMascotByDesigner(designer);
            model.addAttribute("mascots", mascots);
            model.addAttribute("title", "Mascots made by " +designer.getFirstName()+ " " +designer.getLastName());
        }
        else{
            List<Mascot> mascots = mascotService.getAllMascots();
            model.addAttribute("mascots", mascots);
            model.addAttribute("title", "Mascots");
        }
        return "mascotsView";
    }
}
