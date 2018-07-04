package com.mihhd.lab2sports.web.controller;

import com.mihhd.lab2sports.model.Category;
import com.mihhd.lab2sports.config.Layout;
import com.mihhd.lab2sports.service.CategoryService;
import com.mihhd.lab2sports.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Layout("layout/master")
    @GetMapping("/view/{id}")
    public String viewCategory(Model model, @PathVariable ("id") Long id){
        Optional<Category> optCategory = categoryService.findById(id);

        Category noCategory = new Category();
        noCategory.setName("No category with id: " + id);

        model.addAttribute("category", optCategory.orElse(noCategory));
        model.addAttribute("products", productService.findByCategoryId(id));
        return "category";
    }

    @Layout("layout/master")
    @GetMapping("/add")
    public String addCategory(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", new Category());
        return "forms/category.Add";
    }

    @Layout("layout/master")
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        categoryService.save(category);
        return "common/success";
    }

}
