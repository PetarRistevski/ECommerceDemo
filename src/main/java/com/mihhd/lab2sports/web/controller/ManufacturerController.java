package com.mihhd.lab2sports.web.controller;

import com.mihhd.lab2sports.config.Layout;
import com.mihhd.lab2sports.model.Manufacturer;
import com.mihhd.lab2sports.service.CategoryService;
import com.mihhd.lab2sports.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Layout("layout/master")
    @GetMapping("/add")
    public String addManufacturer(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("manufacturer", new Manufacturer());
        return "forms/manufacturer.Add";
    }

    @Layout("layout/master")
    @PostMapping("/save")
    public String saveManufacturer(@ModelAttribute Manufacturer manufacturer, Model model){
        model.addAttribute("categories", categoryService.findAll());
        manufacturerService.save(manufacturer);
        return "common/success";
    }
}
