package com.donishchenko.airbnb.dbutils;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    private String initialQuery;
    private String query;
    private List<Object> values = new ArrayList<>();

    public QueryBuilder(String initialQuery) {
        this.initialQuery = initialQuery;
        this.query = initialQuery;
    }

    public void parseSql(Object[] params) {
        if (params.length != 0) {
            if (params.length % 2 != 0) {
                throw new IllegalArgumentException("An odd number of arguments");
            }

            StringBuilder builder = new StringBuilder(initialQuery);

            builder.append(" WHERE ");
            for (int i = 0; i < params.length; ) {
                builder.append(params[i]).append(" = ?");
                values.add(params[i+1]);

                i += 2;
                if (i < params.length) {
                    builder.append(" AND ");
                }
            }

            query = builder.toString();
        }
    }

//    //TODO refactor
//    public void parseHql(Object[] params) {
//        if (params.length != 0) {
//            StringBuilder builder = new StringBuilder(initialQuery);
//
//            builder.append(" WHERE ");
//            for (int i = 0; i < params.length; i += 2) {
//                String param = (String) params[i];
//                builder.append(param).append(" = :").append(param);
//                values.add(param);
//            }
//
//            query = builder.toString();
//        }
//    }

    public List<Object> values() {
        return values;
    }

    public String getQuery() {
        return query;
    }
}
