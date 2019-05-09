package com.example.demo.api;

import org.springframework.hateoas.ResourceSupport;
import lombok.Getter;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Taco;

import java.util.Date;
import java.util.List;

public class TacoResource extends ResourceSupport {

    private static final IngredientResourceAssembler ingredientAssembler =
            new IngredientResourceAssembler();

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final List<IngredientResource> ingredients;

    public TacoResource(Taco taco){
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toResources(taco.getIngredients());
    }

}
