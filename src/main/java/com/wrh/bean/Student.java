package com.wrh.bean;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午4:51 on 2017/6/5.
 */
public class Student {

    private Integer id;
    private String name;
    private Integer age;

    public Student(){}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
