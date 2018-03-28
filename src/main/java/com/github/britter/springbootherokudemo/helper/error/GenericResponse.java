package com.github.britter.springbootherokudemo.helper.error;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

public class GenericResponse {
    private String status;
    private String error;
    private String message;

    public GenericResponse(final String message) {
        super();
        this.message = message;
    }

    public GenericResponse(final String status, final String error, final String message ) {
        super();
        this.status=status;
        this.error = error;
        this.message = message;

    }

    public GenericResponse(final List<FieldError> fieldErrors, final List<ObjectError> globalErrors) {
        super();
        final ObjectMapper mapper = new ObjectMapper();
        try {
            this.error = mapper.writeValueAsString(globalErrors);
            this.message = mapper.writeValueAsString(fieldErrors);

        } catch (final JsonProcessingException e) {
            this.error = "";
            this.message = "";

        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }
}