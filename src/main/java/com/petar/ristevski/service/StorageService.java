package com.petar.ristevski.service;

import com.petar.ristevski.model.Product;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public void saveFile(Product product, MultipartFile file);
}
