package com.coffee.Random.Coffee.App.Entity;

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
public class Coffee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String test;

}
