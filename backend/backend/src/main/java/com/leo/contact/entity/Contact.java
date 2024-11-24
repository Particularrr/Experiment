package com.leo.contact.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户对象 contact
 *
 * @author leo
 */
@Data
@TableName(value = "contact")
public class Contact
{
    private static final long serialVersionUID = 1L;

    @ExcelIgnore // 不导入导出 id
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ExcelProperty("性别")
    @ColumnWidth(10)
    private String gender;

    @ExcelProperty("姓名")
    @ColumnWidth(10)
    private String name;

    @ExcelProperty("年龄")
    @ColumnWidth(10)
    private String age;

    @ExcelProperty("电话号码1")
    @ColumnWidth(15)
    private String phoneNumber;

    @ExcelProperty("电话号码2")
    @ColumnWidth(15)
    private String phoneNumber2;

    @ExcelProperty("电子邮件地址")
    @ColumnWidth(20)
    private String emailAddress;

    @ExcelProperty("社交媒体地址")
    @ColumnWidth(30)
    private String socialMediaAddress;

    @ExcelProperty("实际地址")
    @ColumnWidth(30)
    private String physicalAddress;

    @ExcelProperty("重要程度")
    @ColumnWidth(15)
    private String importanceLevel;

}
