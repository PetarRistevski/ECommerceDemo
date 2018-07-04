package com.mihhd.lab2sports.web.rest;


import com.mihhd.lab2sports.model.Product;
import com.mihhd.lab2sports.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/product")
public class ProductResources {

    @Autowired
    private ProductService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getAllProducts() {
        return new ArrayList<Product>(service.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/import", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> importProducts(@RequestBody @Valid ArrayList<Product> products){
        for(Product p : products){
            service.save(p);
        }
        return products;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
        public List<Product> getByCategoryId(@PathVariable("id")Long id){
            return service.findByCategoryId(id);
        }
    @RequestMapping(method = RequestMethod.GET, value = "/manufacturer/{name}")
    public List<Product> getByCategoryId(@PathVariable("name") String name) {
            return service.findByManufacturerNameLike(String.format("%%%s%%", name));
    }

    @RequestMapping(value = "/image/{device_id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("device_id") Long deviceId) throws IOException {

        Product Product = service.findOne(deviceId);
        byte[] imageContent = Product.getPhotoData();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }


    }


