package com.xuyuchao.dao;

import com.xuyuchao.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-10:18
 * @Description:
 */
@Repository
public class DeptDao {
    private static Map<Integer, Dept> depts = null;

    static {
        depts = new HashMap<>();
        depts.put(1001,new Dept(1001,"部门一"));
        depts.put(1002,new Dept(1002,"部门二"));
        depts.put(1003,new Dept(1003,"部门三"));
    }

    /**
     * 获取所有部门
     * @return
     */
    public Collection<Dept> getAllDept() {
        return depts.values();
    }

    /**
     * 根据id获取部门
     * @param id
     * @return
     */
    public Dept getDeptById(Integer id) {
        return depts.get(id);
    }
}
