package com.example.curdoperations.repository;

import com.example.curdoperations.domain.EDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<EDepartment,Integer> {
}
