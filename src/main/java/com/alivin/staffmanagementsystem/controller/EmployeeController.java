package com.alivin.staffmanagementsystem.controller;

import com.alivin.staffmanagementsystem.pojo.Department;
import com.alivin.staffmanagementsystem.pojo.Employee;
import com.alivin.staffmanagementsystem.service.impl.DepartmentServiceImpl;
import com.alivin.staffmanagementsystem.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author fer
 */
@Controller
public class EmployeeController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/add")
    public String toAdd(Model model) {
        // 查出所有部门的信息
        List<Department> departments = departmentService.getAll();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/addEmp")
    public String addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/update/{eid}")
    public String toUpdateEmp(@PathVariable("eid") int eid, Model model) {
        Employee employee = employeeService.getEmployeeById(eid);
        model.addAttribute("emp", employee);

        List<Department> departments = departmentService.getAll();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/deleteEmp/{eid}")
    public String deleteEmp(@PathVariable("eid") int eid) {
        employeeService.deleteEmployee(eid);
        return "redirect:/emps";
    }
}
