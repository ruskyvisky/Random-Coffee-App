package com.coffee.Random.Coffee.App.Entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Coffee", description = "Coffee Entity")
public class Coffee {
    @Id
    @GeneratedValue
    private Long id;
    private String coffeeName;
    private String coffeeIngredients;
    private String coffeeCategory;
    private String coffeePrepareTime;
    private String coffeeProfile;
}
