package com.example.curdoperations.service;

import com.example.curdoperations.domain.EProduct;
import com.example.curdoperations.model.Product;
import com.example.curdoperations.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.curdoperations.util.MapperUtil.eProductMapper;
import static com.example.curdoperations.util.MapperUtil.productMapper;


/**
 * Created by Akhil on 10/12/2017.
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product findOne(Integer productId) {
        EProduct eProduct= productRepository.findOne ( productId);
        if(eProduct!=null) {
            return productMapper.apply ( eProduct );
        }
        return  null;
    }

    public Product save(Product product) {
        EProduct eProduct= productRepository.save(eProductMapper.apply(product));
        return productMapper.apply(eProduct);
    }
}
