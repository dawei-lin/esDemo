package com.es.demo.dao;

import com.es.demo.entity.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ldw
 * @date 2019/9/23 15:40
 */
@Mapper
public interface LogDao {
    @Select("select * from log")
    List<Log> getAll();
}
