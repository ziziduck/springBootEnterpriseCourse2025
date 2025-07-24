package com.example.demo4.runner;

import com.example.demo4.entity.Beverage;
import com.example.demo4.repository.BeverageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
@Slf4j
@Order(1)
public class BeverageCRUDRunner implements CommandLineRunner {
    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("repository={}", repository);
        initDB();
        dumpDB("after insert some data");
        modifyDB();
        dumpDB("after modify 3rd beverage");
        deleteDB();
        dumpDB("after delete 1st and 3rd beverage");

    }

    private void deleteDB() {
//        repository.deleteById(1L);
//        repository.deleteById(3L);
        repository.deleteAllById(Arrays.asList(1L, 3L));
    }

    private void modifyDB() {
        Optional<Beverage> optionalBeverage = repository.findById(3L);
        if (optionalBeverage.isPresent()) {
            Beverage beverage = optionalBeverage.get();
            beverage.setTitle("Venti Hot Americano");
            repository.save(beverage);
        }
    }

    private void dumpDB(String prompt) {
        for (Beverage b : repository.findAll()) {
            log.info("after {}, get a beverage={}", prompt, b);
        }
    }

    private void initDB() {
        Beverage b1 = new Beverage();
        b1.setTitle("Tall ice coffee");
        b1.setDetail("Americano");
        b1.setPrice(120);
        b1.setSugar(0.0f);
        Beverage b2 = new Beverage();
        b2.setTitle("Hot grande latte");
        b2.setDetail("3 shot espresso+70% hot milk+...");
        b2.setPrice(200);
        b2.setSugar(0.0f);
        Beverage b3 = new Beverage();
        b3.setTitle("Tall Hot Coffee");
        b3.setDetail("hot americano...");
        b3.setPrice(130);
        b3.setSugar(0.0f);
        Beverage b4 = new Beverage();
        b4.setTitle("Ice Grande Latte");
        b4.setDetail("3 shot espresso+60% fresh milk+ice");
        b4.setPrice(210);
        b4.setSugar(0.0f);
        repository.save(b1);
        repository.save(b2);
        repository.save(b3);
        repository.save(b4);
    }
}