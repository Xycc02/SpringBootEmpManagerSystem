package com.xuyuchao.controller;

import com.xuyuchao.dao.DeptDao;
import com.xuyuchao.dao.EmpDao;
import com.xuyuchao.pojo.Dept;
import com.xuyuchao.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-19-11:24
 * @Description:
 */
@Controller
public class EmpController {
    @Autowired
    private EmpDao empDao;
    @Autowired
    private DeptDao deptDao;

    /**
     * 获取所有员工信息
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String getAllEmp(Model model) {
        Collection<Emp> emps = empDao.getAllEmp();
        model.addAttribute("emps",emps);
        return "/emp/list";
    }

    /**
     * 跳转到添加员工页面
     * @return
     */
    @GetMapping("/addEmp")
    public String toAddEmp(Model model) {
        //查出所有部门信息
        Collection<Dept> depts = deptDao.getAllDept();
        //把所有部门信息共享到前端
        model.addAttribute("depts",depts);
        return "/emp/addEmp";
    }

    /**
     * 添加员工
     * @return
     */
    @PostMapping(value = "/emp")
    public String addEmp(Emp emp) {
        System.out.println(emp);
        empDao.save(emp);
        System.out.println("添加"+emp.getEmpName()+"成功!");
        return "redirect:/emps";
    }

    /**
     * 跳转到员工修改页面
     * @return
     */
    @GetMapping("/updateEmp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id,Model model) {
        //根据id查询员工
        Emp emp = empDao.getEmpById(id);
        System.out.println("修改前=>" + emp);
        //将员工存入request域中
        model.addAttribute("emp",emp);
        //查出所有部门信息
        Collection<Dept> depts = deptDao.getAllDept();
        //把所有部门信息共享到前端
        model.addAttribute("depts",depts);
        return "/emp/updateEmp";
    }

    /**
     * 根据id修改员工
     * @return
     */
    @PostMapping ("/emp/{id}")
    public String updateEmp(Emp emp,@PathVariable("id")Integer id) {
        emp.setId(id);
        System.out.println("修改后=>" + emp);
        empDao.save(emp);
        return "redirect:/emps";
    }

    /**
     * 根据id删除员工
     * @return
     */
    @GetMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id) {
        empDao.deleteEmp(id);
        return "redirect:/emps";
    }
}
