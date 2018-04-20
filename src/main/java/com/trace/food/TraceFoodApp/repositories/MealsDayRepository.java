package com.trace.food.TraceFoodApp.repositories;

import com.trace.food.TraceFoodApp.entities.MealsDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface MealsDayRepository extends JpaRepository<MealsDay,Long> {

    MealsDay findByRoutineDateEquals(Date date);

}
