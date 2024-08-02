package com.javaproject.tariffcalculator.service.exception;

public class EntityNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Class<?> entityClass, String id) {
        super("Entity " + entityClass.getSimpleName() + " with id " + id + " not found.");
    }
}
