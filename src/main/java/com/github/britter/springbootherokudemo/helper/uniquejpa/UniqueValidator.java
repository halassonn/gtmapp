package com.github.britter.springbootherokudemo.helper.uniquejpa;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique,Object> {
    @Autowired
    ApplicationContextProvider applicationContext;
    private FieldValueExists service;
    private String fieldName;

    @Override
    public void initialize(Unique unique) {
        Class<? extends FieldValueExists> clazz = unique.service();
        this.fieldName = unique.fieldName();
        String serviceQualifier = unique.serviceQualifier();

        if (!serviceQualifier.equals("")) {
            this.service = (FieldValueExists) applicationContext.getBean(serviceQualifier, clazz);
        } else {
            this.service = (FieldValueExists) applicationContext.getBean(clazz);
        }

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(applicationContext==null){
            return true;
        }
        return !this.service.fieldValueExists(o, this.fieldName);
    }
}
