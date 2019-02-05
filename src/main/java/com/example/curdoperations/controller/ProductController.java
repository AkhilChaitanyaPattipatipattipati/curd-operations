package com.example.curdoperations.controller;


import com.example.curdoperations.model.Product;
import com.example.curdoperations.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
Akhil
 */
@RestController
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Product findProduct(@RequestParam("product_id") Integer productId){
        return  productService.findOne(productId);
    }
    @RequestMapping(path = "/save",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public @ResponseBody Product saveProduct(@RequestBody Product product){
        return  productService.save(product);
    }
}
