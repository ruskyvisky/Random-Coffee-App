package com.coffee.Random.Coffee.App.Controllers;

import com.coffee.Random.Coffee.App.Entity.Coffee;
import com.coffee.Random.Coffee.App.Messages.Message;
import com.coffee.Random.Coffee.App.Repositories.ICoffeeRepository;
import com.coffee.Random.Coffee.App.ResponseHandler.ResponseHandler;
import com.coffee.Random.Coffee.App.Services.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeService CoffeeService;

    public CoffeeController(CoffeeService CoffeeService) {
        this.CoffeeService = CoffeeService;
    }
    @GetMapping("/random")
    public ResponseEntity<Object> getRandomizedCoffee() {
        return CoffeeService.getRandomizedCoffee();
    }




}
