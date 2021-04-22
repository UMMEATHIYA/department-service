package com.example.demo.service;

import com.example.demo.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    public Department createDepartment(Department department);
    public List<Department> displayAllDepartment();

    public Optional<Department> findDepartment(String id);

    public void deleteDepartment(String id);
}