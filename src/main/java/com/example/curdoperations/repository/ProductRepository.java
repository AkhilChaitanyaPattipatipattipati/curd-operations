package com.example.curdoperations.repository;

import com.example.curdoperations.domain.EProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<EProduct,Integer> {
}
