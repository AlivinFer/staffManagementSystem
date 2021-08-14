package com.alivin.staffmanagementsystem.dao;

import com.alivin.staffmanagementsystem.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {

    // 获取所有员工信息
    public List<Employee> getAll();

    // 根据 id 查询员工信息
    public Employee getEmployeeById(@Param("eid") Integer eid);

    // 添加员工
    public int addEmployee(Employee employee);

    // 更新员工信息
    public int updateEmployee(Employee employee);

    // 根据 id 删除员工信息
    public int deleteEmployee(@Param("eid") Integer eid);

    // 批量删除员工
}
