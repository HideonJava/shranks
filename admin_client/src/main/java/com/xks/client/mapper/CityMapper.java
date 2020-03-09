package com.xks.client.mapper;

import com.xks.client.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CityMapper {
    int add(City city);
    int update(City city);
    int deleteByIds(String id);

    @Select("select * from city where adcode=#{adcode}")
    @Results(id = "city",value= {
            @Result(property = "adcode", column = "adcode", javaType = String.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "id", column = "id", javaType = String.class)
    })
    City queryStudentById(String id);

    @Select("select * from city")
    List<City> getAll();
}
