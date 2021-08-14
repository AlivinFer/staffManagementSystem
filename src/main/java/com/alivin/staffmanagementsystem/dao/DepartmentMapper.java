package com.alivin.staffmanagementsystem.dao;

import com.alivin.staffmanagementsystem.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartmentMapper {
    /**
     * 查询所有部门信息
     * @return List<Department>
     */
    public List<Department> getAll();

    /**
     * 根据 did 查询部门信息
     * @param did 部门 id
     * @return 部门信息
     */
    public Department getDepartmentById(@Param("did") Integer did);
}
