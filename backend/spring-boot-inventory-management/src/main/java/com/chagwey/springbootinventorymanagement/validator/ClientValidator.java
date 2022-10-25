package com.chagwey.springbootinventorymanagement.validator;

import java.util.ArrayList;
import java.util.List;

import com.chagwey.springbootinventorymanagement.model.Client;
import org.springframework.util.StringUtils;


public class ClientValidator {
    public static List<String> validate(Client clientDTO) {
        List<String> errors = new ArrayList<>();
        if (clientDTO == null) {
            errors.add(" Please enter client first name");
            errors.add(" Please enter client last name");
            errors.add(" Please enter client phone number");
            errors.add(" Please enter client email");
            return errors;
        }

        if (!StringUtils.hasLength(clientDTO.getFirstName())) {
            errors.add("Please enter client first name");
        }
        if (!StringUtils.hasLength(clientDTO.getLastName())) {
            errors.add("Please enter client last name");
        }
        if (!StringUtils.hasLength(clientDTO.getPhoneNumber())) {
            errors.add("Please enter client phone number");
        }

        if (!StringUtils.hasLength(clientDTO.getEmail())) {
            errors.add("Please enter client Email");
        }
        return errors;
    }
}
