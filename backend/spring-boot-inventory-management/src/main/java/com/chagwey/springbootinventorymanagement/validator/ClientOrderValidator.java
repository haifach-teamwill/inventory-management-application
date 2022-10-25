package com.chagwey.springbootinventorymanagement.validator;

import com.chagwey.springbootinventorymanagement.model.ClientOrder;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientOrderValidator {

    public static List<String> validate(ClientOrder clientOrder) {

        List<String> errors = new ArrayList<>();

        if (clientOrder == null) {
            errors.add("please enter the order client");
        }

        if (clientOrder.getClient() == null) {
            errors.add("Please enter the order client");
        }
        return errors;
    }

}
