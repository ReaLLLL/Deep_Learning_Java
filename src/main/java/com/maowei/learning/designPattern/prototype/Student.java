package com.maowei.learning.designPattern.prototype;

import java.io.*;

public class Student implements Serializable {
    private String name;
    private int age;
    private School school;

    public Student(String name, int age, School school){
        this.name = name;
        this.age = age;
        this.school = school;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    protected Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("name:");
        sb.append(this.name);
        sb.append(" age:");
        sb.append(this.age);
        sb.append("\nschool:\n");
        sb.append(this.school.toString());
        return  sb.toString();
    }
}
