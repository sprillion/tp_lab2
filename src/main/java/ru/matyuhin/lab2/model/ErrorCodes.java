package ru.matyuhin.lab2.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {

    EMPTY(""),
    VALIDATION_EXCEPTION("ValidationException"),
    UNSUPPORTED_EXCEPTION("UnknownException"),
    UNKNOWN_EXCEPTION("UnsupportedException");

    private final String name;

    ErrorCodes(String description){
        this.name = description;
    }

    @JsonValue
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }
}
