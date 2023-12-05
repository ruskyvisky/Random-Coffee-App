package com.coffee.Random.Coffee.App.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoffeeDTO {

    private String CoffeeName;
    private String CoffeeIngredients;
    private String CoffeeCategory;
    private String CoffeePrepareTime;
    private String CoffeeProfile;

}
