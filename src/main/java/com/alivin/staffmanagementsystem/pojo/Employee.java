package com.alivin.staffmanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author fer
 * @Description: 员工表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer eid;
    private String ename;
    /**
     * 0:女 1：男
     */
    private Integer gender;
    private String email;
    private Date createTime;
    private Date updateTime;
    // 部门表 id
    private Integer did;
    private String dname;
}
