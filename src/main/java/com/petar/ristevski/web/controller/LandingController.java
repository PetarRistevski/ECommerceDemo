package com.petar.ristevski.web.controller;

import com.petar.ristevski.config.Layout;
import com.petar.ristevski.model.Category;
import com.petar.ristevski.model.Product;
import com.petar.ristevski.service.ProductService;
import com.petar.ristevski.service.CategoryService;
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
