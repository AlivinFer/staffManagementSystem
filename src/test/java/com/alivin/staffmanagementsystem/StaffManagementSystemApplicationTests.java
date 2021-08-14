package com.alivin.staffmanagementsystem;

import com.alivin.staffmanagementsystem.pojo.Employee;
import com.alivin.staffmanagementsystem.service.impl.DepartmentServiceImpl;
import com.alivin.staffmanagementsystem.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StaffManagementSystemApplicationTests {

    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    void contextLoads(){
        System.out.println(departmentService.getDepartmentById(1511));
//        System.out.println(employeeService.getEmployeeById(2));
        List<Employee> list = employeeService.getAll();
        for (Employee employee : list) {
            System.out.println(employee);
        }

    }

}
