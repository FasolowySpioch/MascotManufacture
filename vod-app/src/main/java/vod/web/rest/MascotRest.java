package vod.web.rest;

import jakarta.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.Company;
import vod.model.Mascot;
import vod.service.CompanyService;
import vod.service.MascotService;
import vod.web.rest.dto.MascotDTO;

import java.util.List;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class MascotRest {
    private final CompanyService companyService;
    private final MascotService mascotService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    private final MascotValidator mascotValidator;
    //private final CompanyValidator companyValidator;

    //@InitBinder
   // void intitBinder(WebDataBinder binder) { binder.addValidators(companyValidator);}

    @GetMapping("/mascots")
    List<Mascot> getMascots(){
        log.info("about to retrive mascot list");
        List<Mascot> mascots = mascotService.getAllMascots();
        log.info("{} mascots found", mascots.size());
        return mascots;
    }

    @GetMapping("/mascots/{id}")
    ResponseEntity<Mascot> getMascot(@PathVariable("id") int id){
        log.info("about to retrive mascot {}", id);
        Mascot m = mascotService.getMascotById(id);
        log.info("mascot found: {}", m);
        if(m == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else{
            return ResponseEntity.ok(m);
        }
    }

    @GetMapping("companies/{companyId}/mascots")
    ResponseEntity<List<Mascot>> getMascotsByCompany(@PathVariable("companyId") int companyId){
        log.info("about to retrive mascots sold at company {}", companyId);
        Company c = companyService.getCompanyById(companyId);
        if(c == null){
            return ResponseEntity.notFound().build();
        }
        else{
            List<Mascot> mascots = companyService.getMascotsByCompany(c);
            log.info("there's {} mascots at company {}", mascots.size(), c.getName());
            return ResponseEntity.ok(mascots);
        }
    }

    @PostMapping("/mascot")
    ResponseEntity<?> addMascot(@Valid @RequestBody MascotDTO mascotDTO, Errors e, HttpServletRequest request){
        log.info("about to add new mascot {}", mascotDTO);

        //mascotValidator.validate(mascotDTO, errors);

        if (e.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);

            String em = e.getAllErrors().stream().map(oe -> messageSource.getMessage(
                    oe.getCode(),
                    oe.getArguments(),
                    oe.getDefaultMessage(),
                    locale
            )).reduce("errors:\n", (acc, msg)->acc+msg+"\n");

            return ResponseEntity.badRequest().body(em);
        }
        Mascot m = new Mascot();
        m.setName(mascotDTO.getName());
        m.setPhoto(mascotDTO.getPhoto());
        m.setRating(mascotDTO.getRating());
        m.setDesigner(mascotService.getDesignerById(mascotDTO.getDesignerId()));

        m = mascotService.addMascot(m);
        log.info("new mascot added: {}", m);
        //return ResponseEntity.status(HttpStatus.CREATED).body(m);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/"+m.getId()).build().toUri()).body(m);
    }
}
