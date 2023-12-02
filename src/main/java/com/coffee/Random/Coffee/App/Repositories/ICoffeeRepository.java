package com.coffee.Random.Coffee.App.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.coffee.Random.Coffee.App.Entity.Coffee;

@Repository
public interface ICoffeeRepository extends JpaRepository<Coffee, Long> {
}
