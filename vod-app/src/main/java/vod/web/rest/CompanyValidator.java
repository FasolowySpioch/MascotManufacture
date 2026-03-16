package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Company;
import vod.service.CompanyService;

@Component
@RequiredArgsConstructor
public class CompanyValidator implements Validator {

    private final CompanyService cs;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Company.class);
    }

    @Override
    public void validate(Object target, Errors error) {
        if (!(target instanceof Company validateCompany)) {
            return;
        }
        boolean duplicated = cs.getAllCompanies().stream()
                .anyMatch(company ->
                        company.getName().equalsIgnoreCase(validateCompany.getName()));

        if(duplicated){
            error.rejectValue(
                    "name",
                    "company.name.duplicated",
                    "Company name duplicated"
            );
        }
    }
}