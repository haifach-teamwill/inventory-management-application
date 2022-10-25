package com.chagwey.springbootinventorymanagement.interceptor;

import org.hibernate.EmptyInterceptor;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class interceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            final String entityName = sql.substring(7, sql.indexOf("."));
            final String companyId = MDC.get("companyId");
            if (StringUtils.hasLength(entityName)
                    && !entityName.toLowerCase().contains("company")
                    && !entityName.toLowerCase().contains("roles")
                    && StringUtils.hasLength(companyId)) {
            }


            if (sql.contains("where")) {
                sql = sql + " and " + entityName + ".companyId = " + companyId;
            } else {
                sql = sql + " where " + entityName + ".companyId = " + companyId;
            }

        }
        return super.onPrepareStatement(sql);
    }
}