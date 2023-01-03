package com.itheima.domain;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @Author: hsp
 * @Date: 2022/12/30-12-30-21:31
 * @Description: com.itheima.domain
 * @version: 1.0.0
 */
@Data
public class PageBean<T> implements Serializable {

    private Integer currentPage;    //当前页  第1, 2, 3, ...., 16 页

    private Integer pageSize;   //每页显示的记录数  5

    private Integer totalPage;  //总页码数   16页

    private List<T> records;    //当前页记录数  每页5条记录

    private Integer totalRecords;  //总记录  80条记录

}
