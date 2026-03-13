package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Designer;
import vod.service.MascotService;
import vod.web.rest.dto.MascotDTO;

@Component
@RequiredArgsConstructor
public class MascotValidator implements Validator {
    private final MascotService mascotService;

    @Override
    public boolean supports(Class<?> clazz){ return clazz.isAssignableFrom(MascotDTO.class); }

    @Override
    public void validate(Object target, Errors errors){
        MascotDTO mascotDTO = (MascotDTO) target;
        Designer designer = mascotService.getDesignerById(mascotDTO.getDesignerId());
        if(designer == null){
            errors.rejectValue("designerId", "mascot.designer.missing");
        }
    }
}
