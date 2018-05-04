package com.trace.food.TraceFoodApp.repositories;

import com.trace.food.TraceFoodApp.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealReposity extends JpaRepository<Meal,Long> {
}
