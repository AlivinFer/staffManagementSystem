package com.alivin.staffmanagementsystem.service.impl;

import com.alivin.staffmanagementsystem.dao.DepartmentMapper;
import com.alivin.staffmanagementsystem.pojo.Department;
import com.alivin.staffmanagementsystem.service.api.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    // service 层调用 dao 层
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAll() {
        return departmentMapper.getAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentMapper.getDepartmentById(id);
    }
}
