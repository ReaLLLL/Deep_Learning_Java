package com.maowei.learning.designPattern.builder;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private int age;
    private Date birth;

    public Student(String id){
        this(id,null,0,null);
    }

    public Student(String id, String name){
        this(id,name,0,null);
    }

    public Student(String id, String name, int age){
        this(id,name,age,null);
    }

    public Student(String id, String name, int age, Date birth){
        this.id = id;
        this.name = name;
        this.age = age<0?0:age;
        this.birth = birth;
    }

    public Student(Student student){
        this.id = student.id;
        this.name = student.name;
        this.age = student.age;
        this.birth = student.birth;
    }

    public static class Builder{
        private Student target;

        public Builder id(String id){
            target.id = id;
            return this;
        }

        public Builder name(String name){
            target.name = name;
            return this;
        }
        public Builder age(int age){
            target.age = age;
            return this;
        }
        public Builder birth(Date birth){
            target.birth = birth;
            return this;
        }

        public Student build() {
            return new Student(target);
        }
    }

    public static void main(String[] args) {
        Student student = new Student.Builder()
                        .id("10000011")
                        .name("Alex")
                        .age(18)
                        .birth(new Date()).build();
    }
}
