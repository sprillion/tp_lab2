package ru.matyuhin.lab2.model;

public enum Systems {

    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship Management"),
    WMS("Warehouse Management System"),
    SERVICE_1("Service 1"),
    SERVICE_2("Service 2");

    private final String name;

    Systems(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
