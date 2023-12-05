package com.coffee.Random.Coffee.App.Services;

import com.coffee.Random.Coffee.App.DTO.CoffeeDTO;
import com.coffee.Random.Coffee.App.Entity.Coffee;
import com.coffee.Random.Coffee.App.Messages.Message;
import com.coffee.Random.Coffee.App.Repositories.ICoffeeRepository;
import com.coffee.Random.Coffee.App.ResponseHandler.ResponseHandler;
import jakarta.transaction.Transactional;
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

    @Transactional
    public ResponseEntity<Object> addNewCoffee(Coffee coffee){
        if(coffee.getCoffeeName() == null || coffee.getCoffeeIngredients() == null || coffee.getCoffeeCategory() == null || coffee.getCoffeePrepareTime() == null || coffee.getCoffeeProfile() == null){
            return ResponseHandler.generateResponse(Message.MISSING_DATA.getDesc(), HttpStatus.BAD_REQUEST, null);
        }
        if(coffee.getCoffeeName().isEmpty() || coffee.getCoffeeIngredients().isEmpty() || coffee.getCoffeeCategory().isEmpty() || coffee.getCoffeePrepareTime().isEmpty() || coffee.getCoffeeProfile().isEmpty()){
            return ResponseHandler.generateResponse(Message.MISSING_DATA.getDesc(), HttpStatus.BAD_REQUEST, null);
        }
        if(coffee.getCoffeeName().isBlank() || coffee.getCoffeeIngredients().isBlank() || coffee.getCoffeeCategory().isBlank() || coffee.getCoffeePrepareTime().isBlank() || coffee.getCoffeeProfile().isBlank()){
            return ResponseHandler.generateResponse(Message.MISSING_DATA.getDesc(), HttpStatus.BAD_REQUEST, null);
        }
        if(coffee.getCoffeeName().length() > 50 || coffee.getCoffeeIngredients().length() > 50 || coffee.getCoffeeCategory().length() > 50 || coffee.getCoffeePrepareTime().length() > 50 || coffee.getCoffeeProfile().length() > 50){
            return ResponseHandler.generateResponse(Message.DATA_TOO_LONG.getDesc(), HttpStatus.BAD_REQUEST, null);
        }
        if(coffee.getCoffeeName().length() < 3 || coffee.getCoffeeIngredients().length() < 3 || coffee.getCoffeeCategory().length() < 3 || coffee.getCoffeePrepareTime().length() < 3 || coffee.getCoffeeProfile().length() < 3){
            return ResponseHandler.generateResponse(Message.DATA_TOO_SHORT.getDesc(), HttpStatus.BAD_REQUEST, null);
        }
        if(coffee.getCoffeeName().matches(".*\\d.*")  || coffee.getCoffeeCategory().matches(".*\\d.*")  || coffee.getCoffeeProfile().matches(".*\\d.*")){
            return ResponseHandler.generateResponse(Message.DATA_CONTAINS_NUMBER.getDesc(), HttpStatus.BAD_REQUEST, null);
        }

        var existingCoffee = coffeeRepository.findByCoffeeName(coffee.getCoffeeName());
        if(existingCoffee != null){
            return ResponseHandler.generateResponse(Message.ALREADY_EXISTS.getDesc(), HttpStatus.BAD_REQUEST, null);
        }
        coffeeRepository.save(coffee);
        CoffeeDTO coffeeDTO = new CoffeeDTO();
        coffeeDTO.setCoffeeName(coffee.getCoffeeName());
        coffeeDTO.setCoffeeIngredients(coffee.getCoffeeIngredients());
        coffeeDTO.setCoffeeCategory(coffee.getCoffeeCategory());
        coffeeDTO.setCoffeePrepareTime(coffee.getCoffeePrepareTime());
        coffeeDTO.setCoffeeProfile(coffee.getCoffeeProfile());
        return ResponseHandler.generateResponse(Message.SUCCESS.getDesc(), HttpStatus.OK, coffeeDTO);
    }


}
