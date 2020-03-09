package com.xks.client.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {

    private static final long serialVersionUID = 273454483047663161L;
    private String id;
    private String name;
    private String adcode;
    private String citycode;
}
