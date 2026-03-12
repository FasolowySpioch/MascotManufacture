package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.Company;
import vod.model.Mascot;
import vod.service.CompanyService;
import vod.service.MascotService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/webapi")
public class CompanyRest {
    private final CompanyService companyService;
    private final MascotService mascotService;

    @GetMapping("/companies")
    List<Company> getCompanies(@RequestParam(value = "phrase", required = false) String phrase,
                               @RequestHeader(value = "custom-header", required = false) String customHeader,
                               @CookieValue(value = "some-cookie", required = false) String someCookie) {
        log.info("about to fetch companies list");
        log.info("phrase param: {}", phrase);
        log.info("custom header param: {}", customHeader);
        log.info("some cookie value: {}", someCookie);
        List<Company> companies = companyService.getAllCompanies();
        log.info("{} companies found. ", companies.size());
        return companies;
    }

    @GetMapping("/companies/{id}")
    ResponseEntity<Company> getCompany(@PathVariable("id") int id){
        log.info("about to fetch company {}", id);
        Company c = companyService.getCompanyById(id);
        log.info("company found {}", c);
        if(c != null){
            return ResponseEntity.status(200).body(c);
        }
        else return ResponseEntity.notFound().build(); //ERR 404
    }

    @GetMapping("/mascots/{mascotId}/companies")
    ResponseEntity<List<Company>> getCompaniesWithMascot(@PathVariable("mascotId") int mascotID){
        log.info("about to fetch companies with mascot {}", mascotID);
        Mascot m = mascotService.getMascotById(mascotID);
        if(m != null){
            List<Company> ls = companyService.getCompaniesByMascots(m);
            log.info("there is {} companies selling this mascot{}", ls.size(), m.getName());
            return ResponseEntity.ok(ls);
        }
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("/companies")
    ResponseEntity<Company> addCompany(@RequestBody Company c){
        log.info("about to add new company {}", c);
        //TODO:VALIDATE
        c = companyService.addCompany(c);
        log.info("new company added {}: ", c);
        return ResponseEntity.status(HttpStatus.CREATED).body(c);
    }
}
