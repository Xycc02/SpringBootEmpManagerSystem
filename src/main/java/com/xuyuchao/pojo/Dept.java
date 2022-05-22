package com.xuyuchao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xuyuchao
 * @Date: 2022-05-18-10:05
 * @Description:
 */
//部门表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Integer id;
    private String deptName;
}
