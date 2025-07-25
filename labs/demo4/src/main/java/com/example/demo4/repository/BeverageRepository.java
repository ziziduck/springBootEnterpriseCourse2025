package com.example.demo4.repository;

import com.example.demo4.entity.Beverage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BeverageRepository extends CrudRepository<Beverage, Long> {

    List<Beverage> findByPriceBetweenOrderByPriceAsc(Integer lower, Integer upper);

    List<Beverage> findByTitleContainingIgnoreCase(String t);

    List<Beverage> findByTitleLike(String title);

    List<Beverage> findByTitleAndDetailOrderByPriceAsc(String t, String d);

    List<Beverage> findByTitleOrDetailOrderByPriceAsc(String t, String d);

    List<Beverage> findByTitleIgnoreCaseAndDetailOrderByPriceAsc(String t, String d);

    List<Beverage> findByTitleAndDetailOrderByPriceAscAllIgnoreCase(String t, String d);

    Page<Beverage> findByOrderByPriceAsc(Pageable pageable);

    Page<Beverage> findAll(Pageable pageable);

    List<Beverage> findByOrderByPriceAsc();

    List<Beverage> findByOrderByPriceDesc();

    //List<Beverage> findByOrderByDiscountAsc();
    List<Beverage> findMatchByTitle(String t);

    List<Beverage> findMatchByTitleOrderByPriceAsc(String title);

    List<Beverage> findMatchByTitleIgnoreCaseOrderByPriceAsc(String title);

    Integer countByTitle(String t);

}