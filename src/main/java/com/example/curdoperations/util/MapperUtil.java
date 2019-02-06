package com.example.curdoperations.util;


import com.example.curdoperations.domain.EDepartment;
import com.example.curdoperations.domain.EProduct;
import com.example.curdoperations.model.Department;
import com.example.curdoperations.model.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Akhil on 10/12/2017.
 */
public class MapperUtil {
    public static Function<EProduct, Product> productMapper = eProduct -> {
        Department department = new Department ();
        department.setDepartmentId ( eProduct.getEDepartment ().getDepartmentId () );
        department.setDepartmentName ( eProduct.getEDepartment ().getDepartmentName () );
        department.setDepartmentDescription ( eProduct.getEDepartment ().getDepartmentDescription () );

        Product product = new Product ();
        product.setProductId ( eProduct.getProductId () );
        product.setProductName ( eProduct.getProductName () );
        product.setProductDescription ( eProduct.getProductDescription () );
        product.setDepartment ( department );
        return product;
    };
    public static Function<Product, EProduct> eProductMapper = product -> {
        EDepartment eDepartment = null;
        if (product.getDepartment () != null) {
            eDepartment = new EDepartment ();
            eDepartment.setDepartmentId ( product.getDepartment ().getDepartmentId () );
            eDepartment.setDepartmentName ( product.getDepartment ().getDepartmentName () );
            eDepartment.setDepartmentDescription ( product.getDepartment ().getDepartmentDescription () );
        }
        EProduct eProduct = new EProduct ();
        eProduct.setProductId ( product.getProductId () );
        eProduct.setProductName ( product.getProductName () );
        eProduct.setProductDescription ( product.getProductDescription () );
        eProduct.setEDepartment ( eDepartment );
        return eProduct;

    };
    public static Function<EDepartment, Department> departmentMapper = eDepartment -> {
        List<Product> productList = eDepartment.getProducts ().stream ().map ( eProduct -> {
                                                                                   Product product = new Product ();
                                                                                   product.setProductId ( eProduct.getProductId () );
                                                                                   product.setProductName ( eProduct.getProductName () );
                                                                                   product.setProductDescription ( eProduct.getProductDescription () );
                                                                                   return product;
                                                                               }
        ).collect ( Collectors.toList () );
        Department department = new Department ();
        department.setDepartmentId ( eDepartment.getDepartmentId () );
        department.setDepartmentName ( eDepartment.getDepartmentName () );
        department.setDepartmentDescription ( eDepartment.getDepartmentDescription () );
        department.setProducts ( productList );
        return department;
    };
    public static Function<Department, EDepartment> eDepartmentMapper = department -> {
        EDepartment eDepartment = new EDepartment ();
        eDepartment.setDepartmentId ( department.getDepartmentId () );
        eDepartment.setDepartmentName ( department.getDepartmentName () );
        eDepartment.setDepartmentDescription ( department.getDepartmentDescription () );
        eDepartment.setProducts ( department.getProducts ().stream ().map ( eProductMapper ).collect ( Collectors.toList () ) );
        return eDepartment;
    };

}
