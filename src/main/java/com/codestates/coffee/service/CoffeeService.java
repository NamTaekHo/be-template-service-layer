package com.codestates.coffee.service;

import com.codestates.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee){
        // DB 안배워서 했다침
        return coffee;
    }

    public Coffee updateCoffee(Coffee coffee){
        // 마찬가지로 DB 했다침
        return coffee;
    }

    public Coffee findCoffee(long coffeeId){
        // DB이슈로 조회했다치고 더미데ㅣ터
        Coffee coffee = new Coffee(coffeeId, "아아", "IA", 2000);

        return coffee;
    }

    public List<Coffee> findCoffees(){
        List<Coffee> coffees = List.of(
                new Coffee(1, "아아", "IA", 2000),
                new Coffee(2, "아아2", "IA2", 3000),
                new Coffee(3, "아아3", "IA3", 4000)
        );
        return coffees;
    }

    public void deleteCoffee(long coffeeId){

    }
}
