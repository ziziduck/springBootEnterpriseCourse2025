package com.example.demo4.repository;

import com.example.demo4.entity.Beverage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BeverageRepository extends CrudRepository<Beverage, Long> {
    Page<Beverage> findAll(Pageable pageable);

    List<Beverage> findByOrderByPriceAsc();

    List<Beverage> findByOrderByPriceDesc();

    //List<Beverage> findByOrderByDiscountAsc();
    List<Beverage> findMatchByTitle(String t);

    List<Beverage> findMatchByTitleIgnoreCaseOrderByPriceAsc(String title);

    List<Beverage> findMatchByTitleOrderByPriceAsc(String title);

    Integer countByTitle(String t);

}