package com.atguigu.controller;

import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 孙消飞
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {

    private static final String PAGE_INDEX = "role/index";
    private static final String PAGE_CREATE = "role/create";
    private static final String PAGE_SUCCESS = "common/successPage";
    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public String save(Role role, Model model){
        roleService.insert(role);
        model.addAttribute("messagePage","添加成功，哈哈哈");
        return PAGE_SUCCESS;
    }

    @RequestMapping("/create")
    public String create(){
        return PAGE_CREATE;
    }

    @RequestMapping
    public String index(ModelMap model){
        List<Role> list = roleService.findAll();
        model.addAttribute("list",list);
        return PAGE_INDEX;
    }
}
