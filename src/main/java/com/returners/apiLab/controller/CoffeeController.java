package com.returners.apiLab.controller;

import com.returners.apiLab.model.Coffee;
import com.returners.apiLab.util.CoffeeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CoffeeController {

    @GetMapping(value = "/coffeelover")
    public String coffeeLover() {
        return "I like coffee!";
    }

    @GetMapping("/coffee")
    public Coffee coffee(@RequestParam(value = "name", defaultValue = "Cortado") String name) {
        CoffeeType type = CoffeeType.coffeeByType(name);
        return new Coffee(type.getValue(), type.getType());
    }

    @GetMapping("/AllCoffeeTypes")
    public List<Coffee> AllCoffeeTypes() {
        return CoffeeType.getAllTypes().stream()
                .map(c -> new Coffee(c.getValue(), c.getType()))
                .collect(Collectors.toList());

    }


}
