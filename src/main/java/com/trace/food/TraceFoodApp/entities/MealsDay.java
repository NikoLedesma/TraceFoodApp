package com.trace.food.TraceFoodApp.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meals_day")
public class MealsDay {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_meals_day")
    private List <Meal> meals= new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(name="routine_date", nullable = false, unique = true)
    private Date routineDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Date getRoutineDate() {
        return routineDate;
    }

    public void setRoutineDate(Date routineDate) {
        this.routineDate = routineDate;
    }
}
