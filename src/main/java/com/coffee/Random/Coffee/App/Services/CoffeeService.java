package com.coffee.Random.Coffee.App.Services;

import com.coffee.Random.Coffee.App.Entity.Coffee;
import com.coffee.Random.Coffee.App.Messages.Message;
import com.coffee.Random.Coffee.App.Repositories.ICoffeeRepository;
import com.coffee.Random.Coffee.App.ResponseHandler.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CoffeeService {
    private final ICoffeeRepository coffeeRepository;

    Random rand = new Random();

    public CoffeeService(ICoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }
    public ResponseEntity<Object> getRandomizedCoffee() {
        long rowNumber = coffeeRepository.count();
        long randomRowNumber = rand.nextInt((int) rowNumber) + 1;

        Optional<Coffee> randomCoffee = coffeeRepository.findById(randomRowNumber);
        if (randomCoffee.isEmpty()) {
            return ResponseHandler.generateResponse(Message.NOT_FOUND.getDesc(), HttpStatus.NOT_FOUND, null);
        }


        return ResponseHandler.generateResponse(Message.SUCCESS.getDesc(), HttpStatus.OK, randomCoffee);
    }


}
