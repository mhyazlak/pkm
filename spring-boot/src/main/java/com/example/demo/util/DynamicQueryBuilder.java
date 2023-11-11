package com.example.demo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class DynamicQueryBuilder {

    private StringBuilder sb;
    private List<QueryParam> queryParams;
    private List<QueryParam> sortParams;
    private EntityManager em;

    public DynamicQueryBuilder(String baseQuery, EntityManager em) {
        this.sb = new StringBuilder(baseQuery);
        this.queryParams = new ArrayList<>();
        this.sortParams = new ArrayList<>();
        this.em = em;
    }

    public void addQueryParam(String columnName, String operator, Object value) {
        queryParams.add(new QueryParam(columnName, operator, value));
    }

    public void addSortParam(String sortByValue, String sortDirection) {
        sortParams.add(new QueryParam(sortByValue, sortDirection));  // No value or index needed for sort params
    }

    public Query buildQuery(Class<?> className) {
        List<String> params = new ArrayList<>();
        int paramIndex = 1; // Initialize the parameter index
        // building conditions in WHERE
        for (int i = 0; i < queryParams.size(); i++) {
            QueryParam queryParam = queryParams.get(i);

            String columnName = queryParam.getColumnName();
            String op = queryParam.getOperator();
            Object value = queryParam.getValue();

            if (value instanceof String) {
                sb.append(i == 0 ? "\nWHERE " : "\nAND ");
                sb.append(columnName);
                switch (op) {
                    case "EQ" -> {
                        sb.append(" LIKE ?").append(paramIndex); // Use a simple placeholder
                        params.add("%" + (String) value + "%"); // Wrap the string with wildcards here
                    }
                }
                paramIndex++;
            } else if (value instanceof String[]) {
                sb.append(i == 0 ? "\nWHERE " : "\nOR ");
                sb.append(columnName);
                switch (op) {
                    case "IN" -> {
                        sb.append(" IN ("); // Use a simple placeholder
                    }
                }

                String[] values = (String[]) value;
                for (int j =0;j< values.length;j++) {
                    sb.append("?").append(paramIndex);
                    if(j != values.length-1) {
                        sb.append(", ");
                    }
                    params.add(values[j]);
                    paramIndex++;
                }
                sb.append(", NULL)");
            }


        }

        // building Order By
        for (QueryParam sortParam : sortParams) {
            sb.append("\nORDER BY ").append(sortParam.getColumnName());
        }

        Query query = em.createNativeQuery(sb.toString(), className);
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i + 1, params.get(i));
        }

        return query;
    }

}
