package com.maowei.learning.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: AnnotationTest.java, v 0.1 2017年12月25日 下午6:09:09 alexsong Exp $
 */
public class AnnotationTest {
    public static void main(String[] args){
        Student s = new Student();

        Annotation[] annotations = s.getClass().getAnnotations();

        for(Annotation a : annotations){
            if(a instanceof Person){
                Person p = (Person)a;
                System.out.println("ClassName:"+p.name());
            }
        }

        Field[] fields = s.getClass().getDeclaredFields();
        for(Field f : fields){
            if(f.isAnnotationPresent(Person.class)){
                Person p = (Person)f.getAnnotation(Person.class);
                System.out.println("name:"+ p.name());
                System.out.println("gender:"+ p.studentGender());
                System.out.println("age:"+ p.age());
            }
        }
    }
}
