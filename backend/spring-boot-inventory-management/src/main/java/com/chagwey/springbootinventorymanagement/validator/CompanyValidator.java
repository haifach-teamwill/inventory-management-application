package com.chagwey.springbootinventorymanagement.validator;

import java.util.ArrayList;
import java.util.List;

import com.chagwey.springbootinventorymanagement.model.Company;
import org.springframework.util.StringUtils;


public class CompanyValidator {

    public static List<String> validate(Company companyDTO) {
        List<String> errors = new ArrayList<>();
        if (companyDTO == null) {
            errors.add(" Please enter company name");
            errors.add(" Please enter company description");
            errors.add("Please enter company tax code");
            errors.add("Please enter company phone number");
            return errors;
        }

        if (!StringUtils.hasLength(companyDTO.getName())) {
            errors.add("Please enter company name");
        }
        if (!StringUtils.hasLength(companyDTO.getDescription())) {
            errors.add("Please enter company description");
        }
        if (!StringUtils.hasLength(companyDTO.getEmail())) {
            errors.add("Please enter company email");
        }
        if (!StringUtils.hasLength(companyDTO.getPhoneNumber())) {
            errors.add("Please enter company phone number");
        }
        if (companyDTO.getAddress() == null) {
            errors.add("Please enter company address");
        } else {

            if (!StringUtils.hasLength(companyDTO.getAddress().getAddress1())) {
                errors.add(" 'Adress 1'field is mandatory ");
            }
            if (!StringUtils.hasLength(companyDTO.getAddress().getCity())) {
                errors.add(" 'City' field is mandatory ");
            }
            if (!StringUtils.hasLength(companyDTO.getAddress().getZipCode())) {
                errors.add(" 'Zip Code' field is mandatory");
            }
            if (!StringUtils.hasLength(companyDTO.getAddress().getCountry())) {
                errors.add("'Country' field is mandatory");
            }
        }
        return errors;
    }

}
