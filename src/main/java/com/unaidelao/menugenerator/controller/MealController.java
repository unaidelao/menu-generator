package com.unaidelao.menugenerator.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unaidelao.menugenerator.model.Meal;
import com.unaidelao.menugenerator.repositories.MealRepository;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @PostMapping("")
    public Meal create(@RequestBody Meal meal) {
        return mealRepository.insert(meal);
    }

    @GetMapping("/{mealId}")
    public Optional<Meal> getMealById(@PathVariable String mealId) {
        return mealRepository.findById(mealId);
    }

    @GetMapping("")
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
}
