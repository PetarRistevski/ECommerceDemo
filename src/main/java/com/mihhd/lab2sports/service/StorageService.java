package com.mihhd.lab2sports.service;

import com.mihhd.lab2sports.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public void saveFile(Product product, MultipartFile file);
}
