package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice(basePackages = "vod.web.rest")
@RequiredArgsConstructor
@Slf4j
public class VodAdvice {
    private final CompanyValidator companyValidator;
    private final MascotValidator mascotValidator;

    @InitBinder("company")
    void initCompanyBinder(WebDataBinder binder) {binder.addValidators(companyValidator);}

    @InitBinder("mascotDTO")
    void initMascotBinder(WebDataBinder binder) {binder.addValidators(mascotValidator);}

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgsException(IllegalArgumentException e){
        log.error("illegal argument provided:", e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }
}
