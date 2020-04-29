package com.sergei.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private Long id;

    private String name;

    private String type;

    private static final long serialVersionUID = 1L;

    public Role(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Role() {
        super();
    }

}