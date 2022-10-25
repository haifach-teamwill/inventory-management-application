package com.chagwey.springbootinventorymanagement.validator;

import com.chagwey.springbootinventorymanagement.model.ClientOrderItem;

import java.util.ArrayList;
import java.util.List;

public class ClientOrderItemValidator {

    public static List<String> validate(ClientOrderItem clientOrderItem) {

        List<String> errors = new ArrayList<>();

        if (clientOrderItem == null) {
            errors.add("Please enter the order code");
            errors.add("please enter the order client");
        }

        if (clientOrderItem.getArticle() == null) {
            errors.add("Please enter the order client");
        }
        if (clientOrderItem.getQuantity() == null) {
            errors.add("Please enter the order client");
        }
        if (clientOrderItem.getQuantity() == null) {
            errors.add("Please enter the order client");
        }
        return errors;
    }
}
