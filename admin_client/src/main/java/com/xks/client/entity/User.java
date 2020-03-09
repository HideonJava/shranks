package com.xks.client.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 6222261350397598984L;

    private Integer id;
    private String userName;
    private String password;
    private Date createTime;
    private String status;
}
