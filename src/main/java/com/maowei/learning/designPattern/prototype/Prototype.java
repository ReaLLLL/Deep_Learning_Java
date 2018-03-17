package com.maowei.learning.designPattern.prototype;

public class Prototype {
    public static void main(String[] args){

        School school = new School("AAA","Junior High");
        Student studentA = new Student("alex", 0, school);
        System.out.println(studentA.toString());

        try {
            Student studentB = (Student) studentA.deepClone();
            System.out.println(studentB.toString());

            System.out.println("======================");

            school.setName("BBB");
            school.setType("Senior High");
            studentA.setName("Jack");
            studentA.setAge(10);

            System.out.println(studentA.toString());
            System.out.println(studentB.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
