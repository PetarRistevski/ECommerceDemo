package com.petar.ristevski.web.controller;

import com.petar.ristevski.config.Layout;
import com.petar.ristevski.model.Manufacturer;
import com.petar.ristevski.service.CategoryService;
import com.petar.ristevski.service.ManufacturerService;
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
