package com.xks.client.service;

import com.xks.client.entity.City;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@CacheConfig(cacheNames = "city")
@Repository
public interface CityService {
    int add(City city);
    int update(City city);
    int deleteByIds(String id);
    @Cacheable(keyGenerator = "wiselyKeyGenerator",value = "adcode")
    City queryStudentById(String adcode);
    //@Cacheable(keyGenerator = "wiselyKeyGenerator",value = "list")
    List<City> getAll();
}
