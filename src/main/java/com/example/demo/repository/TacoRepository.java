package com.example.demo.repository;
import com.example.demo.model.Taco;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

public interface TacoRepository
    extends PagingAndSortingRepository<Taco, Long> {

    //List<Taco> findAll(PageRequest page);

}
