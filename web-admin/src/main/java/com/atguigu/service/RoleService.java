package com.atguigu.service;

import com.atguigu.base.BaseService;
import com.atguigu.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author 孙消飞
 * @version 1.0
 */
public interface RoleService extends BaseService<Role> {
    List<Role> findAll();
}
