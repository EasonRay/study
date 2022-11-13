package com.ln.mybatis.mapper;

import com.ln.mybatis.pojo.Dept;
import com.ln.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);


    /**
     * 获取部门以及部门中所有的员工信息
     */
    Dept getDeptAndEmp(@Param("did") Integer did);


    /**
     * 通分布查询查询部门以及部门中所有的员工信息
     * 1.查询部门信息
     */
    Dept getDeptAndEmpOne(@Param("did") Integer did);
}
