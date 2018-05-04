package com.trace.food.TraceFoodApp.repositories;

import com.trace.food.TraceFoodApp.entities.MealsDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MealsDayRepository extends JpaRepository<MealsDay,Long> {

    MealsDay findByRoutineDateEquals(Date date);

}
