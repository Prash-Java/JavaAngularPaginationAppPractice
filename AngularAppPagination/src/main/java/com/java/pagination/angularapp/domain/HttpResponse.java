package com.java.pagination.angularapp.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@SuperBuilder
@JsonInclude(NON_DEFAULT)
public class HttpResponse {
    protected String timeStamp;
    protected int statusCode;
    protected String status;
    protected String message;
    protected Map<?,?> data;
}
