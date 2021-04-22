package com.example.demo.service;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentDao.save(department);
    }

    @Override

    public List<Department> displayAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public Optional<Department> findDepartment(String id) {
        return departmentDao.findById(id);
    }

    @Override
    public void deleteDepartmentById(String id) {
        departmentDao.deleteById(id);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.save(department);
    }

    @Override
    public void deleteAllDepartments() {
        departmentDao.deleteAll();
    }

    @Override
    public Department getDepartmentByEmployeeName(String employeeName) {
        return departmentDao.getDepartmentByEmployeeName(employeeName);
    }


}