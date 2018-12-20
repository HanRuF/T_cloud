package com.xiaoyu.tpolice.c;

import javax.validation.constraints.Min;

public class CustomerService {

    private String name;
    private String sex;
    private String manager;

    @Min(value = 2)
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public String getSex() {
        return sex;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
