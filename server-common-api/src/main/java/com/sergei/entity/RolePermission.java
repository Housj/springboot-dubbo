package com.sergei.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePermission implements Serializable {
    private Long rid;

    private Long pid;

    private static final long serialVersionUID = 1L;

    public RolePermission(Long rid, Long pid) {
        this.rid = rid;
        this.pid = pid;
    }

    public RolePermission() {
        super();
    }
}