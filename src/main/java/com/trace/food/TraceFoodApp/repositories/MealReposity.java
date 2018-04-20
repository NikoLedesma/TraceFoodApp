package com.trace.food.TraceFoodApp.repositories;

import com.trace.food.TraceFoodApp.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealReposity extends JpaRepository<Meal,Long> {
}
