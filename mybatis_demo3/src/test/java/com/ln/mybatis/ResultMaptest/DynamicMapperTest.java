package com.ln.mybatis.ResultMaptest;

import com.ln.mybatis.mapper.DynamicSQLMapper;
import com.ln.mybatis.pojo.Emp;
import com.ln.mybatis.uitls.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {


    /**
     *动态SQL：
     *if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     *
     *where:
     *当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and 或or去掉
     *当where标签中有内容时，此时where标签没有任何效果
     *注意：where标签不能将内容后面的多余的and 或or去掉
     *
     *trim:
     * 当标签中有内容时：
     * prefix|suffix:将trim标签中内容前面或后面添加指定内容
     * suffixOverrides|prefixOverrides:将trim标签中内容前面或后面去掉指定内容
     *
     * choose,when,otherwise 相当于if，else if，else
     * when标签至少有一个，otherwise标签至多有一个
     *
     * foreach标签
     * collection:设置需要循环的数组
     * item：表示数组或集合中的每一个数据
     * separator：循环体之间的分隔符
     * open：foreach标签所循环的所有内容的开始符
     * close：foreach标签所循环的所有内容的结束符
     *
     * sql标签：<sql id="empcols">eid,emp_name,age,sex,email</sql>
     * 引用sql片段：<include refid="empcols"></include>
     */
    @Test
    public void testIf(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        for (Emp emp : mapper.getEmpByCondition(new Emp(null, "张三", 23, null, null))) {
            System.out.println(emp);
        }
    }
    @Test
    public void testChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = mapper.getEmpByChoose(new Emp(null, "", null, null, null));
        System.out.println(emps);
    }

    @Test
    public void testdeleteMoreByArray(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int i = mapper.deleteMoreByArray(new Integer[]{6, 7, 8});
        System.out.println(i);
    }

    @Test
    public void testinsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "a1", 23, "男", "1213");
        Emp emp2 = new Emp(null, "a2", 23, "男", "1213");
        Emp emp3 = new Emp(null, "a3", 23, "男", "1213");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int i = mapper.insertMoreByList(emps);
        System.out.println(i);
    }
}
