package com.sergei.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
    private Long uid;

    private Long rid;

    private static final long serialVersionUID = 1L;

    public UserRole(Long uid, Long rid) {
        this.uid = uid;
        this.rid = rid;
    }

    public UserRole() {
        super();
    }

}