package com.maowei.learning.json;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Person.java, v 0.1 2017年12月21日 上午11:14:14 alexsong Exp $
 */
public class Person {
    private String name;
    private int age;
    private List<String> address;
    private String[] phoneNums;
    private Boolean isMarried;
    private List<Person> friends = new ArrayList<Person>();

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public String[] getPhoneNums() {
        return phoneNums;
    }

    public void setPhoneNums(String[] phoneNums) {
        this.phoneNums = phoneNums;
    }

    public Boolean getMarried() {
        return isMarried;
    }

    public void setMarried(Boolean married) {
        isMarried = married;
    }

    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
}
