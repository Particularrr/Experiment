package com.leo.contact.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.contact.mapper.ContactMapper;
import com.leo.contact.entity.Contact;
import com.leo.contact.service.ContactService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @Author Leo
 * @Description :com.leo.contact.service.impl
 * @Date:Created in   2024/11/24
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {

    @Override
    public void importContacts(MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空！");
        }

        // 使用 EasyExcel 读取数据
        ExcelReaderBuilder reader = EasyExcel.read(file.getInputStream(), Contact.class,
                new PageReadListener<Contact>(contacts -> {
                    // 批量插入到数据库
                    this.saveBatch(contacts);
                }));
        reader.sheet().doRead();
    }

    @Override
    public void exportContacts(HttpServletResponse response) throws IOException {
        // 查询数据库数据
        List<Contact> contacts = this.list();

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("通讯录", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

        // 使用 EasyExcel 写入数据
        EasyExcel.write(response.getOutputStream(), Contact.class)
//                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()) // 自动列宽
                .sheet("通讯录")
                .doWrite(contacts);
    }

}
