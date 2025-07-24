package com.example.demo4.controller;

import com.example.demo4.entity.Beverage;
import com.example.demo4.form.BeverageForm;
import com.example.demo4.repository.BeverageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeverageController {
    @Autowired
    private BeverageRepository repository;
    private static final String LIST_URL = "/beverages/all";
    private static final String REDIRECT_URL = "redirect:" + LIST_URL;

    @GetMapping("/beverages/add")
    public String showAddBeverage(Model model) {
        BeverageForm f = new BeverageForm();
        model.addAttribute("beverageForm", f);
        return "beverage/add";
    }

    @GetMapping(LIST_URL)
    public String getAllBeverage(Model model) {
        model.addAttribute("beverages", repository.findByOrderByPriceAsc());
        return "beverage/list";
    }

    @PostMapping("/beverages/add")
    public String storeAddedBeverage(BeverageForm f) {
        Beverage b = getEntityFromForm(f);
        repository.save(b);
        return REDIRECT_URL;
    }

    @GetMapping("/beverages/delete")
    public String delAction(@RequestParam Long id) {
        repository.deleteById(id);
        return REDIRECT_URL;
    }

    @GetMapping("/beverages/modify")
    public String showModify(@RequestParam Long id, Model model) {
        Beverage b = repository.findById(id).get();
        BeverageForm f = getFormFromEntity(b);
        model.addAttribute("beverageForm", f);
        return "beverage/modify"; // need to do later
    }

    @PostMapping("/beverages/modify")
    public String storeModifiedBeverage(BeverageForm f) {
        Beverage b = getEntityFromForm(f);
        repository.save(b);
        return REDIRECT_URL;
    }

    private BeverageForm getFormFromEntity(Beverage b) {
        BeverageForm f = new BeverageForm();
        BeanUtils.copyProperties(b, f);
        return f;
    }

    private Beverage getEntityFromForm(BeverageForm f) {
        Beverage b = new Beverage();
        BeanUtils.copyProperties(f, b);
        return b;
    }
}