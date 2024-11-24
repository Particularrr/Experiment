package com.leo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author leo
 */
@MapperScan(basePackages = "com.leo.contact.mapper")
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class LeoApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(LeoApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  contact系统启动成功， ლ(´ڡ`ლ)ﾞ ");
    }
}
