package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Taco;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IngredientRepository
    extends CrudRepository<Ingredient, String> {

}

