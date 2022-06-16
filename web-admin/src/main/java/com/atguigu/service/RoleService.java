package com.atguigu.service;

import com.atguigu.entity.Role;

import java.util.List;

/**
 * @author 孙消飞
 * @version 1.0
 */
public interface RoleService {
    List<Role> findAll();

    Integer insert(Role role);

    Role getById(Long id);

    Integer update(Role role);

    void delete(Long id);
}
