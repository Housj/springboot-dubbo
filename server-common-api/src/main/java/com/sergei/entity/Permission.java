package com.sergei.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {

    private Long id;

    private String url;

    private String name;

    private static final long serialVersionUID = 1L;

    public Permission(){super();}

    public Permission(Long id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

}