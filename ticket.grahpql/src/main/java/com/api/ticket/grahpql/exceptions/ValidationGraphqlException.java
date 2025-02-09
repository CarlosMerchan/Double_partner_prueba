package com.api.ticket.grahpql.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Data;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class ValidationGraphqlException extends  RuntimeException implements GraphQLError {

    private String message;

    public ValidationGraphqlException(String message){
        this.message = message;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> attribute = new LinkedHashMap<>();
        attribute.put("status", HttpStatus.BAD_REQUEST.value());
        return attribute;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return List.of();
    }

    @Override
    public ErrorClassification getErrorType() {
        return ErrorType.BAD_REQUEST;
    }
}
