package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.Company;
import vod.model.Mascot;
import vod.service.CompanyService;
import vod.service.MascotService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CompanyController {
    private final CompanyService companyService;
    private final MascotService mascotService;

    @GetMapping("/companies")
    String getCompanies(Model model, @RequestParam(value = "mascotId", required = false) Integer mascotId){
        log.info("about to displat companies list with mascot {}", mascotId);
        if(mascotId!=null){
            Mascot mascot = mascotService.getMascotById(mascotId);
            List<Company> companies = companyService.getCompaniesByMascots(mascot);
            model.addAttribute("companies", companies);
            model.addAttribute("title", "Companies");
        }
        else{
            List<Company> companies = companyService.getAllCompanies();
            model.addAttribute("companies", companies);
            model.addAttribute("title", "Companies");
        }

        return "companiesView";
    }
}
