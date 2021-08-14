package com.alivin.staffmanagementsystem.service.impl;

import com.alivin.staffmanagementsystem.dao.EmployeeMapper;
import com.alivin.staffmanagementsystem.pojo.Employee;
import com.alivin.staffmanagementsystem.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Override
    public Employee getEmployeeById(Integer eid) {
        return employeeMapper.getEmployeeById(eid);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public int deleteEmployee(Integer eid) {
        return employeeMapper.deleteEmployee(eid);
    }
}
