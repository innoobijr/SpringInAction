package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import java.util.Date;
import java.util.List;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.rest.core.annotation.RestResource;


@Data
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // annotations for the entity
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private final String name;

    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

}
