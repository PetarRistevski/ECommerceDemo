package com.mihhd.lab2sports.service.impl;

import com.mihhd.lab2sports.model.Product;
import com.mihhd.lab2sports.service.ProductService;
import com.mihhd.lab2sports.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    ProductService productService;

    @Override
    public void saveFile(Product product, MultipartFile file) {
        try {
            product.setPhotoData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.save(product);
    }
}