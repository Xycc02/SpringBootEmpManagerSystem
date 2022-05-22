package com.xuyuchao.dao;

import com.xuyuchao.pojo.Dept;
import com.xuyuchao.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-10:36
 * @Description:
 */
@Repository
public class EmpDao {
    private static Map<Integer, Emp> emps = null;

    @Autowired
    private DeptDao deptDao;

    static {
        emps = new HashMap<>();
        // Integer id = 1001;
        //初始化员工数据
        // for(int i = 1;i <= 5;i++) {
        //     String uid = UUID.randomUUID().toString().substring(0,5)+i;
        //     emps.put(id++,new Emp(id++,uid,uid+"@qq.com",0,new Dept(1001,"部门一"),new Date()));
        // }
        emps.put(1001,new Emp(1001,"张三","123456@qq.com",0,new Dept(1001,"部门一"),new Date()));
        emps.put(1002,new Emp(1002,"李四","123456@qq.com",1,new Dept(1002,"部门二"),new Date()));
        emps.put(1003,new Emp(1003,"王五","123456@qq.com",0,new Dept(1003,"部门三"),new Date()));
        emps.put(1004,new Emp(1004,"田六","123456@qq.com",1,new Dept(1002,"部门二"),new Date()));
        emps.put(1005,new Emp(1005,"赵七","123456@qq.com",0,new Dept(1001,"部门一"),new Date()));
    }

    //主键自增
    private static Integer initId = 1006;

    /**
     * 保存员工
     */
    public void save(Emp emp) {
        if(emp.getId() == null) {
            emp.setId(initId++);
        }

        emp.setDept(deptDao.getDeptById(emp.getDept().getId()));
        emps.put(emp.getId(),emp);
    }

    /**
     * 查询所有员工信息
     * @return
     */
    public Collection<Emp> getAllEmp() {
        return emps.values();
    }

    /**
     * 根据id查找员工
     * @param id
     * @return
     */
    public Emp getEmpById(Integer id) {
        return emps.get(id);
    }

    public void deleteEmp(Integer id) {
        emps.remove(id);
    }
}
