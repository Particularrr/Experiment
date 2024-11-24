package com.leo.contact.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leo.contact.entity.Contact;
import com.leo.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author Leo
 * @Description :com.leo.contact.controller
 * @Date:Created in   2024/11/24
 */

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService userService;

    // 新增联系人
    @PostMapping
    public String addContact(@RequestBody Contact contact) {
        userService.save(contact);
        return "新增成功";
    }

    // 修改联系人
    @PutMapping("/{id}")
    public String updateContact(@PathVariable Integer id, @RequestBody Contact contact) {
        contact.setId(id);
        userService.updateById(contact);
        return "修改成功";
    }

    // 删除联系人
    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Integer id) {
        userService.removeById(id);
        return "删除成功";
    }

    // 获取联系人列表
    @GetMapping
    public List<Contact> getAllContacts() {
        QueryWrapper qw=new QueryWrapper();
        qw.orderByDesc("name");
        return userService.list(qw);
    }
    //查询联系人
    @PostMapping("/query")
    public List<Contact> query(String name,String importanceLevel) {

        QueryWrapper qw=new QueryWrapper();
        if (null!=name&&!"".equals(name)){
        qw.like("name",name);}
        if (null!=importanceLevel&&!"".equals(importanceLevel)){
        qw.eq("importance_level",importanceLevel);}
        qw.orderByDesc("name");
        return userService.list(qw);
    }


    // 导入通讯录
    @PostMapping("/import")
    public String importContacts(@RequestParam("file") MultipartFile file) {
        try {
            userService.importContacts(file);
            return "导入成功";
        } catch (Exception e) {
            return "导入失败：" + e.getMessage();
        }
    }

    // 导出通讯录
    @GetMapping("/export")
    public void exportContacts(HttpServletResponse response) {
        try {
            userService.exportContacts(response);
        } catch (IOException e) {
            throw new RuntimeException("导出失败：" + e.getMessage());
        }
    }

}
