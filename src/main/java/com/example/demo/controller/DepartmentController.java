package com.example.demo.controller;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<Department>(departmentService.createDepartment(department),HttpStatus.CREATED);
    }
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> displayAll()
    {
        return new ResponseEntity<List<Department>>(departmentService.displayAllDepartment(),HttpStatus.OK);
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable("id") String id)
    {
        return ResponseEntity.ok(departmentService.findDepartment(id));
    }

    @GetMapping(value = "/departments/employee/{employeeName}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable(value="employeeName") String name){
        return  ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartmentByEmployeeName(name));
    }

    @PutMapping(value= "departments/update/{id}")
    public String update(@PathVariable(value= "id") Integer id, @RequestBody Department d) {
        d.setDepartmentId(id);
        departmentService.updateDepartment(d);
        return "Employee record for employee-id= " + id + " updated.";
    }


    @DeleteMapping(value= "departments/delete/{id}")
    public void delete(@PathVariable(value= "id") String id) {
        departmentService.deleteDepartmentById(id);
    }


    @DeleteMapping(value= "departments/deleteall")
    public void deleteAll() {
        departmentService.deleteAllDepartments();

    }
}

