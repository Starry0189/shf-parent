package com.atguigu.dao;

import com.atguigu.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 孙消飞
 * @version 1.0
 */
@Repository
public interface RoleDao {
    List<Role> findAll();

    Integer insert(Role role);
}
