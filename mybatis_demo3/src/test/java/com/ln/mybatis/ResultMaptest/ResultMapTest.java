package com.ln.mybatis.ResultMaptest;

import com.ln.mybatis.mapper.DeptMapper;
import com.ln.mybatis.mapper.EmpMapper;
import com.ln.mybatis.pojo.Dept;
import com.ln.mybatis.pojo.Emp;
import com.ln.mybatis.uitls.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.net.SocketAddress;

public class ResultMapTest {
    @Test
    public void testgetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        for (Emp emp : mapper.getAllEmp()) {
            System.out.println(emp);
        }

    }

    @Test
    public void testgetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDept(3);
        System.out.println(empAndDept);
    }


    @Test
    public void testgetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp empAndDept = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(empAndDept.getEmpName());
    }


    @Test
    public void testgetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }



    @Test
    public void testgetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmpOne(1);
        System.out.println(deptAndEmp);
    }
}
