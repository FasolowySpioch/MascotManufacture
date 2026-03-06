package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.Company;
import vod.service.CompanyService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CompanyRest {
    private final CompanyService companyService;

    @GetMapping("/companies")
    List<Company> getCompanies(){
        log.info("about to fetch companies list");
        List<Company> companies = companyService.getAllCompanies();
        log.info("{} companies found. ", companies.size());
        return companies;
    }
}
