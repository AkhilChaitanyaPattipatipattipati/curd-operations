package com.example.curdoperations.controller;


import com.example.curdoperations.model.Department;
import com.example.curdoperations.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
10/12/2017.
 */
@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Department findDepartment(@RequestParam("department_id") Integer departmentId) {
        return departmentService.fineOne(departmentId);
    }

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Department saveDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }
}
