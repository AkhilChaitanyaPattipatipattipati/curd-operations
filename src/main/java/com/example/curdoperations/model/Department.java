package com.example.curdoperations.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 10/12/2017.
 */
//@JsonDeserialize(builder = Department.Builder.class)
public class Department {

    @JsonProperty
    private Integer departmentId;

    @JsonProperty
    private String departmentName;
    @JsonProperty
    private String departmentDescription;
    @JsonProperty
    private List<Product> products = new ArrayList<>();


   /* public Department(Builder builder) {
        this.departmentId = builder.departmentId;
        this.departmentName = builder.departmentName;
        this.departmentDescription = builder.departmentDescription;
        this.products = builder.products;
    }*/

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    /* @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "")
    public static class Builder {
        private Integer departmentId;
        private String departmentName;
        private String departmentDescription;
        private List<Product> products = new ArrayList<>();

        public Builder departmentId(Integer departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder departmentName(String departmentName) {
            this.departmentName = departmentName;
            return this;
        }

        public Builder departmentDescription(String departmentDescription) {
            this.departmentDescription = departmentDescription;
            return this;
        }

        public Builder products(List<Product> products) {
            this.products = products;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }*/
}
