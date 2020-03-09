package com.xks.client.controller;

import com.xks.client.entity.City;
import com.xks.client.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api("测试Controller")
@RestController
public class testController {
    @Autowired
    private CityService cityService;

    //@Log("执行方法一")
    @ApiIgnore
    @GetMapping("/one")
    public void methodOne(String name) { }

    //@Log("执行方法二")
    @ApiIgnore
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    //@Log("执行方法三")
    @ApiIgnore
    @GetMapping("/three")
    public void methodThree(String name, String age) { }

    //@Log("/getCity")
    @ApiOperation(value = "获取城市信息", notes = "根据城市编码城市信息")
    @ApiImplicitParam(name = "adcode", value = "adcode", required = true, dataType = "String", paramType = "path")
    @GetMapping(value = "/getCity")
    public City getCity(String adcode){
        City city = cityService.queryStudentById(adcode);
        return city;
    }

    //@Log("/getAll")
    @ApiOperation(value = "获取城市列表", notes = "获取城市列表")
    @GetMapping(value = "/getAll")
    public List<City> getAll(){
        List<City> list = cityService.getAll();
        System.out.println("--------->start");

        return list;
    }
}
