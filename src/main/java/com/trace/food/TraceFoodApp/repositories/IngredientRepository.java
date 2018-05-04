package com.trace.food.TraceFoodApp.repositories;

import com.trace.food.TraceFoodApp.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
