package com.unaidelao.menugenerator.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.unaidelao.menugenerator.model.type.MealType;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Document(collection = "meals")
public class Meal {

    @Id
    private String id;

    private String description;
    private MealType mealType;

}
