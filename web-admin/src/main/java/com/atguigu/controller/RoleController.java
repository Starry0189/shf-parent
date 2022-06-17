package com.atguigu.controller;

import com.atguigu.base.BaseController;
import com.atguigu.entity.Role;
import com.atguigu.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 孙消飞
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends BaseController {

    private static final String PAGE_INDEX = "role/index";
    private static final String PAGE_CREATE = "role/create";
    private static final String PAGE_EDIT = "role/edit";
    private static final String LIST_ACTION = "redirect:/role";

    @Autowired
    private RoleService roleService;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        roleService.delete(id);
        return LIST_ACTION;
    }

    @PostMapping("/update")
    public String update(Role role,HttpServletRequest request){
        roleService.update(role);
        return this.successPage("修改成功，哈哈哈",request);
    }

    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable Long id){
        Role role = roleService.getById(id);
        model.addAttribute("role",role);
        return PAGE_EDIT;
    }

    @PostMapping("/save")
    public String save(Role role,HttpServletRequest request){
        roleService.insert(role);
        return this.successPage("添加成功，哈哈哈",request);
    }

    @RequestMapping("/create")
    public String create(){
        return PAGE_CREATE;
    }

    /*
    @RequestMapping
    public String index(ModelMap model){
        List<Role> list = roleService.findAll();
        model.addAttribute("list",list);
        return PAGE_INDEX;
    }
     */
    @RequestMapping
    public String index(ModelMap model, HttpServletRequest request) {
        Map<String,Object> filters = getFilters(request);
        PageInfo<Role> page = roleService.findPage(filters);
        model.addAttribute("page",page);
        model.addAttribute("filters",filters);
        return PAGE_INDEX;
    }
}
