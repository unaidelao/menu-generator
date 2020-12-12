package com.unaidelao.menugenerator.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unaidelao.menugenerator.model.Meal;

public interface MealRepository extends MongoRepository<Meal, String> {
}
