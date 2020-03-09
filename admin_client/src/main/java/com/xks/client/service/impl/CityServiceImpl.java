package com.xks.client.service.impl;

import com.xks.client.entity.City;
import com.xks.client.mapper.CityMapper;
import com.xks.client.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentService")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    @Override
    public int add(City city) {
        return cityMapper.add(city);
    }

    @Override
    public int update(City city) {
        return 0;
    }

    @Override
    public int deleteByIds(String id) {
        return 0;
    }

    @Override
    public City queryStudentById(String adcode) {
        return cityMapper.queryStudentById(adcode);
    }

    @Override
    public List<City> getAll() {
        return cityMapper.getAll();
    }

}
