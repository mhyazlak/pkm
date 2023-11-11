package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QueryParam {

    private String columnName;
    private String operator;
    private Object value;

    // Constructor for sort parameters
    public QueryParam(String sortByValue, String sortDirection) {
        this.columnName = sortByValue;
        this.operator = sortDirection;
    }

    // Constructor for query parameters
    public QueryParam(String columnName, String operator, Object value) {
        this.columnName = columnName;
        this.operator = operator;
        this.value = value;
    }

}
