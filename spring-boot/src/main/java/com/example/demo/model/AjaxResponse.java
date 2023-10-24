package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AjaxResponse<T, V> implements Serializable {

    private static final long serialVersionUID = -8891523163503184026L;

    private boolean success;
    private T statusCode;
    private String message;
    private V data;
    private long total;

    public AjaxResponse(final boolean success) {
        this.success = success;
    }

    public AjaxResponse(final boolean success, final String message) {
        this.success = success;
        this.message = message;
    }

    public AjaxResponse(final boolean success, final T statusCode, final String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
    }

    public AjaxResponse(final boolean success, final V data, final long total) {
        this.success = success;
        this.data = data;
        this.total = total;
    }

    public AjaxResponse(final boolean success, final T statusCode, final String message, final V data) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public AjaxResponse() {

    }

}