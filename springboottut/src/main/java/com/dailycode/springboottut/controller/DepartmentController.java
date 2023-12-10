package com.dailycode.springboottut.controller;

import com.dailycode.springboottut.entity.Department;
import com.dailycode.springboottut.error.DepartmentNotFoundException;
import com.dailycode.springboottut.servicce.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department)
    {
        logger.info("Inside saveDepartment() of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartment()
    {
        logger.info("Inside getAllDepartment() of DepartmentController");
        return departmentService.getAllDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        logger.info("Inside getDepartmentById() of DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
    {
        logger.info("Inside deleteDepartmentById() of DepartmentController");

        departmentService.deleteDepartmentByid(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department)
    {
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName)
    {
        return departmentService.getDepartmentByName(departmentName);
    }
}
