package com.returners.apiLab.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public     enum CoffeeType{


    Espresso(1,"Espresso"),
    Double_Espresso(2,"Double Espresso"),
    Cappuccino(3,"Cappuccino"),
    Americano(4,"Americano"),
    Long_Black(5,"Long Black"),
    Macchiato(6,"Macchiato"),
    Long_Macchiato(7,"Long Black"),
    Cortado(8,"Cortado"),
    Flat_White(9,"Flat White"),
    Cafe_Latte(10,"Café Latte"),
    Mocha(11,"Mocha"),
    Affogato(12,"Affogato"),
    Cafe_au_Lait(13,"Café au Lait"),
    Iced_coffee(14,"Iced coffee");

    final String type;
    final int value;

    private static final Map<Integer, CoffeeType> BY_COFFEE = new HashMap<>();
    private static final Map<String, CoffeeType> BY_COFFEE_NAME = new HashMap<>();

    static {
        for (CoffeeType e: values()) {
            BY_COFFEE.put(e.getValue(), e);
            BY_COFFEE_NAME.put(e.getType(), e);
        }
    }

    CoffeeType(int value,String coffeeType) {
        this.type = coffeeType;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public static CoffeeType coffeeBy(int value) {
        return BY_COFFEE.get(value);
    }
    public static CoffeeType coffeeByType(String name) {
        return BY_COFFEE_NAME.get(name);
    }

    public static List<CoffeeType>  getAllTypes() {
        return Arrays.stream(values()).toList();
    }
}

