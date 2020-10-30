package com.example.util.annotation;

import java.lang.annotation.*;

/**
 * @author WangRui
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}