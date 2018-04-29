package com.trace.food.TraceFoodApp.entities;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meal")
public class Meal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String Description;

    @Temporal(TemporalType.TIMESTAMP)//save date and time
    @Column (name = "input_date_time",nullable = false)
    private Date inputDateTime;

    @Temporal(TemporalType.TIMESTAMP)//save date and time
    @Column (name = "date_time")
    private Date mealDate;

    @ManyToOne
    private MealType mealType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_meal")
    private List<Ingredient> ingredients;

    @PrePersist
    protected void onCreate() {
        this.inputDateTime = new Date();
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Date getInputDateTime() {
        return inputDateTime;
    }

    public void setInputDateTime(Date inputDateTime) {
        this.inputDateTime = inputDateTime;
    }

    public Date getMealDate() { return mealDate; }

    public void setMealDate(Date mealDate) { this.mealDate = mealDate; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meal meal = (Meal) o;

        return id == meal.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
