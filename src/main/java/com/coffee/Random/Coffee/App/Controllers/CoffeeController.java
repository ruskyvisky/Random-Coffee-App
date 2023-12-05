package com.coffee.Random.Coffee.App.Controllers;

import com.coffee.Random.Coffee.App.Services.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/coffee")
@Tag(name = "Coffee",description = "Coffee API")
public class CoffeeController {

    private final CoffeeService CoffeeService;

    public CoffeeController(CoffeeService CoffeeService) {
        this.CoffeeService = CoffeeService;
    }
    @GetMapping("/random")
    @Operation(summary = "Get Randomized Coffee", description = "Get Randomized Coffee")
    public ResponseEntity<Object> getRandomizedCoffee() {

        return CoffeeService.getRandomizedCoffee();
    }




}
