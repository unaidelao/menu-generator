package com.unaidelao.menugenerator.controller;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.unaidelao.menugenerator.model.Meal;
import com.unaidelao.menugenerator.repositories.MealRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MealControllerTest {

    @InjectMocks
    private MealController controller;

    @Mock
    private MealRepository repository;

    @Mock
    private Meal mockMeal;

    private static final String testId = "5fd54606b371a579f6ee8306";


    @Test
    public void shouldGetMealById() {
        // given
        when(repository.findById(testId)).thenReturn(Optional.of(mockMeal));
        // when
        Optional<Meal> returnedMeal = controller.getMealById(testId);
        // then
        assertTrue(returnedMeal.isPresent());
        assertEquals(mockMeal, returnedMeal.get());
        verify(repository).findById(testId);
    }

    @Test
    public void shouldCreateMeal() {
        // when
        controller.create(mockMeal);
        // then
        verify(repository).insert(mockMeal);
    }

    @Test
    public void shouldGetAllMeals() {
        // when
        controller.getAllMeals();
        // then
        verify(repository).findAll();
    }

    @Test
    public void shouldDeleteMealById() {
        // when
        controller.deleteMeal(testId);
        // then
        verify(repository).deleteById(testId);
    }
}
