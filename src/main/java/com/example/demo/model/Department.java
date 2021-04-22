package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("departments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    private Integer departmentId;
    private String departmentName;
    private String employeeName;
}