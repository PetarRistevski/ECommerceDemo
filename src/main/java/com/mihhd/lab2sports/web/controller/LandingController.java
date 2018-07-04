package com.mihhd.lab2sports.web.controller;

import com.mihhd.lab2sports.config.Layout;
import com.mihhd.lab2sports.model.Category;
import com.mihhd.lab2sports.model.Product;
import com.mihhd.lab2sports.service.ProductService;
import com.mihhd.lab2sports.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class LandingController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Layout("layout/master")
    @GetMapping("/")
    public String index(Model model) {
        List<Category> categoryList = new ArrayList<>(categoryService.findAll());
        List<Product> products = new ArrayList<>(productService.findAll());
        model.addAttribute("categories", categoryList);
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/category/{id}")
    public String categoryItems(Model model, @PathVariable Long id) {
        Optional<Category> optCategory = categoryService.findById(id);

        Category noCategory = new Category();
        noCategory.setName("No category with id: " + id);

        model.addAttribute("category", optCategory.orElse(noCategory));
        return "category";
    }

    @Layout("/layout/master")
    @GetMapping("/products/{id}")
    public String deviceView(Model model, @PathVariable ("id") Long id) {
        Product product = productService.findOne(id);
        model.addAttribute("product",product);
        return "products";
    }

}
