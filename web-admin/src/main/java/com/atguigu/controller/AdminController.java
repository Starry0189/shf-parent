package com.atguigu.controller;

import com.atguigu.base.BaseController;
import com.atguigu.entity.Admin;
import com.atguigu.service.AdminService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author 孙消飞
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    private static final String PAGE_INDEX = "admin/index";
    private static final String PAGE_CREATE = "admin/create";
    private static final String PAGE_EDIT = "admin/edit";
    private static final String LIST_ACTION = "redirect:/admin";

    @Autowired
    private AdminService adminService;

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        adminService.delete(id);
        return LIST_ACTION;
    }

    @PostMapping("/update")
    public String update(Admin admin,HttpServletRequest request){
        adminService.update(admin);
        return this.successPage("修改成功，哈哈哈",request);
    }

    @GetMapping("/edit/{id}")
    public String edit(ModelMap model, @PathVariable Long id){
        Admin admin = adminService.getById(id);
        model.addAttribute("admin",admin);
        return PAGE_EDIT;
    }

    @PostMapping("/save")
    public String save(Admin admin,HttpServletRequest request){
        admin.setHeadUrl("http://47.93.148.192:8080/group1/M00/03/F0/rBHu8mHqbpSAU0jVAAAgiJmKg0o148.jpg");
        adminService.insert(admin);
        return this.successPage("添加成功，哈哈哈",request);
    }

    @RequestMapping("/create")
    public String create(){
        return PAGE_CREATE;
    }

    /*
    @RequestMapping
    public String index(ModelMap model){
        List<Admin> list = adminService.findAll();
        model.addAttribute("list",list);
        return PAGE_INDEX;
    }
     */
    @RequestMapping
    public String index(ModelMap model, HttpServletRequest request) {
        Map<String,Object> filters = getFilters(request);
        PageInfo<Admin> page = adminService.findPage(filters);
        model.addAttribute("page",page);
        model.addAttribute("filters",filters);
        return PAGE_INDEX;
    }
}
