package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import vod.model.Company;
import vod.service.CompanyService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final CompanyService cs;

    public VodComponent(CompanyService cs) { this.cs = cs; }

    @PostConstruct
    public void init(){
        List<Company> companies = cs.getAllCompanies();
        companies.sort(Comparator.comparing(Company::getId));
        log.info("{} companies found. ", companies.size());
        companies.forEach(company -> log.info("{}", company));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Company> companies = cs.getAllCompanies();
        companies.sort(Comparator.comparing(Company::getId));
        log.info("{} companies found. ", companies.size());
        companies.forEach(company -> log.info("{}", company));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {log.info("on context refreshed (another method)");}
}
