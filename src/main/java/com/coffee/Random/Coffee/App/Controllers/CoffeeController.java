package com.coffee.Random.Coffee.App.Controllers;

import com.coffee.Random.Coffee.App.DTO.CoffeeDTO;
import com.coffee.Random.Coffee.App.Entity.Coffee;
import com.coffee.Random.Coffee.App.Services.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/coffee")
@Tag(name = "Coffee",description = "Coffee API")
public class CoffeeController {

    private final CoffeeService CoffeeService;

    public CoffeeController(CoffeeService CoffeeService) {
        this.CoffeeService = CoffeeService;
    }
    @GetMapping("/random")
    @Operation(summary = "Get Random Coffee", description = "Get Randomized Coffee")
    public ResponseEntity<Object> getRandomizedCoffee() {

        return CoffeeService.getRandomizedCoffee();
    }

    @PostMapping("/add")
    @Operation(summary = "Add New Coffee", description = "Add New Coffee")
    public ResponseEntity<Object> addNewCoffee(@RequestBody Coffee coffee) {

        return CoffeeService.addNewCoffee(coffee);
    }




}
