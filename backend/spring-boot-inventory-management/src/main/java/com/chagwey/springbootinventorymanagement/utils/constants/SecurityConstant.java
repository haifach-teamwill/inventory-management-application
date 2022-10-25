package com.chagwey.springbootinventorymanagement.utils.constants;

public class SecurityConstant {

    public static final String[] PUBLIC_URLS = {"/**/authenticate"
            , "/**/users/**"
            , "/**/articles/**"
            , "/**/categories/**"
            , "/**/clientsOrders/**"
            , "/swagger-resources"
            , "/swagger-resources/**"
            , "/configuration/ui"
            , "/configuration/security"
            , "/webjars/**"
            , "/swagger-ui/**"
            , "/swagger-ui.html"
            , "/v3/api-docs/**"
            , "/v2/api-docs"};
}
