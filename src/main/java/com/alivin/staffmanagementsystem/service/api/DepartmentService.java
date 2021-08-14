package com.alivin.staffmanagementsystem.service.api;


import com.alivin.staffmanagementsystem.pojo.Department;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAll();

    public Department getDepartmentById(Integer id);
}
