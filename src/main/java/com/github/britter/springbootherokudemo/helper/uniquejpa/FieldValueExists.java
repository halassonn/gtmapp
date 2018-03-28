package com.github.britter.springbootherokudemo.helper.uniquejpa;

public interface FieldValueExists {
    boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException;
}
