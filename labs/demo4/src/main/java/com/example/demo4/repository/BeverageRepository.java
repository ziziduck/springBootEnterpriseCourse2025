package com.example.demo4.repository;

import com.example.demo4.entity.Beverage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BeverageRepository extends CrudRepository<Beverage,Long> {
}