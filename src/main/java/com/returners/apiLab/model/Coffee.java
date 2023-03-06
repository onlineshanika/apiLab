package com.returners.apiLab.model;

public class Coffee {
    private final int id;
    private final String name;

    public Coffee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}