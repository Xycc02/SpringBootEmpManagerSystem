package com.xuyuchao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-10:05
 * @Description:
 */
//员工表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Integer id;
    private String empName;
    private String email;
    private Integer gender;//0:女    1:男
    private Dept dept;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
