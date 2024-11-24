package com.leo.contact.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.contact.entity.Contact;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Leo
 * @Description :com.leo.contact.service
 * @Date:Created in   2024/11/24
 */
public interface ContactService extends IService<Contact> {
    void importContacts(MultipartFile file) throws Exception;

    void exportContacts(HttpServletResponse response) throws IOException;
}
