package com.maowei.learning.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Student.java, v 0.1 2017年12月25日 下午3:42:42 alexsong Exp $
 */
public class Student {
    @Person(name = "Alex")
    private String name;

    @Person(studentGender = Person.gender.male)
    private String gender;

    @Person(age = 17)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("After Init!");
    }

    @PreDestroy
    public void beforeDestroy(){
        System.out.println("Before Destroy!");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name:");
        sb.append(this.name);
        sb.append(" gender:");
        sb.append(this.gender);
        sb.append(" age:");
        sb.append(this.age);

        return sb.toString();
    }
}
