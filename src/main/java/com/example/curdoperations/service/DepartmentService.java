package com.example.curdoperations.service;


import com.example.curdoperations.domain.EDepartment;
import com.example.curdoperations.model.Department;
import com.example.curdoperations.repository.DepartmentRepository;
import com.example.curdoperations.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 10/12/2017.
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department fineOne(Integer departmentId) {
        EDepartment eDepartment = departmentRepository.findOne ( departmentId);
        Department department = null;
        if (eDepartment!=null) {
            department = MapperUtil.departmentMapper.apply( eDepartment);
        }
        return department;
    }

    public Department save(Department department) {
        EDepartment edepartment =MapperUtil. eDepartmentMapper.apply(department);
        return MapperUtil.departmentMapper.apply(departmentRepository.save(edepartment));
    }
}