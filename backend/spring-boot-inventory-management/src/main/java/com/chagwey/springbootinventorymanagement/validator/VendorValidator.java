package com.chagwey.springbootinventorymanagement.validator;

import java.util.ArrayList;
import java.util.List;

import com.chagwey.springbootinventorymanagement.model.Vendor;
import org.springframework.util.StringUtils;


public class VendorValidator {

    public static List<String> validate(Vendor vendorDTO) {
        List<String> errors = new ArrayList<>();
        if (vendorDTO == null) {
            errors.add(" Please enter vendor first name");
            errors.add(" Please enter vendor last name");
            errors.add(" Please enter vendor phone number");
            errors.add(" Please enter vendor email");
            return errors;
        }

        if (!StringUtils.hasLength(vendorDTO.getFirstName())) {
            errors.add("Please enter vendor first name");
        }
        if (!StringUtils.hasLength(vendorDTO.getLastName())) {
            errors.add("Please enter vendor last name");
        }
        if (!StringUtils.hasLength(vendorDTO.getPhoneNumber())) {
            errors.add("Please enter vendor phone number");
        }
        if (!StringUtils.hasLength(vendorDTO.getEmail())) {
            errors.add("Please enter vendor Email");
        }
        return errors;
    }
}
