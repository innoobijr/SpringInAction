package com.example.demo.repository;
import com.example.demo.model.Taco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TacoRepository
    extends CrudRepository<Taco, Long> {

}
