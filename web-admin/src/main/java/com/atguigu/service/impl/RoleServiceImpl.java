package com.atguigu.service.impl;

import com.atguigu.dao.RoleDao;
import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孙消飞
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Integer insert(Role role) {
        Integer count = roleDao.insert(role);
        return count;
    }

    @Override
    public Role getById(Long id) {
        Role role = roleDao.getById(id);
        return role;
    }

    @Override
    public Integer update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public void delete(Long id) {
        roleDao.delete(id);
    }
}
