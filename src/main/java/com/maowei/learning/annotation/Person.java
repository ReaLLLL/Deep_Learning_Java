package com.maowei.learning.annotation;

import java.lang.annotation.*;

/**
 * <p>注释</p>
 *
 * @author alexsong
 * @version $Id: Person.java, v 0.1 2017年12月25日 下午3:13:13 alexsong Exp $
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {
    String name() default "";

    public enum gender{male, female};

    public gender studentGender() default gender.male;

    int age() default 0;
}
