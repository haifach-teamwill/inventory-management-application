package com.chagwey.springbootinventorymanagement.validator;

import java.util.ArrayList;
import java.util.List;

import com.chagwey.springbootinventorymanagement.model.User;
import org.springframework.util.StringUtils;


public class UserValidator {

    public static List<String> validate(User userDTO) {
        List<String> errors = new ArrayList<>();
        if (userDTO == null) {
            errors.add(" Please enter user first name");
            errors.add(" Please enter user last name");
            errors.add(" Please enter user password");
            errors.add(" Please enter user address");
            return errors;
        }

        if (!StringUtils.hasLength(userDTO.getFirstName())) {
            errors.add("Please enter user first name");
        }
        if (!StringUtils.hasLength(userDTO.getLastName())) {
            errors.add("Please enter user last name");
        }
        if (!StringUtils.hasLength(userDTO.getPassword())) {
            errors.add("Please enter user password");
        }
        if (!StringUtils.hasLength(userDTO.getEmail())) {
            errors.add("Please enter user Email");
        }
        if (userDTO.getBirthDay() == null) {
            errors.add("Please enter user birthDay");
        }
        if (userDTO.getAddress() == null) {
            errors.add("Please enter user address");
        } else {

            if (!StringUtils.hasLength(userDTO.getAddress().getAddress1())) {
                errors.add(" 'Adress 1'field is mandatory ");
            }
            if (!StringUtils.hasLength(userDTO.getAddress().getCity())) {
                errors.add(" 'City' field is mandatory ");
            }
            if (!StringUtils.hasLength(userDTO.getAddress().getZipCode())) {
                errors.add(" 'Zip Code' field is mandatory");
            }
            if (!StringUtils.hasLength(userDTO.getAddress().getCountry())) {
                errors.add("'Country' field is mandatory");
            }
        }
        return errors;
    }

}
