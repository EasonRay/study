package com.ln.mybatis.mapper;

import com.ln.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    /**
     * 查询所有员工信息
     */
    List<Emp> getAllEmp();


    Emp getEmpAndDept(@Param("eid") Integer eid);

    /**
     * 通过分步查询查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);


    /**
     * 通分布查询查询部门以及部门中所有的员工信息
     * 2.查询部门所对应的员工信息
     */
    List<Emp> getDeptAndEmpTwo(@Param("did") Integer did);
}
