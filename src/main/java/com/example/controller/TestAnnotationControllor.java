package com.example.controller;

import com.example.util.annotation.TestAnnotation;
import com.example.vo.firut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

/**
 * @author WangRui
 */
@RestController
@RequestMapping("/test")
public class TestAnnotationControllor {

    @GetMapping("/annotation")
    public void test() throws NoSuchFieldException {
        // 获取类模板
        Class c = firut.class;

        // 获取所有字段
        Field [] name = c.getFields();
        for (Field f : name
             ) {
            if(f.isAnnotationPresent(TestAnnotation.class)) {
                TestAnnotation annotation = f.getAnnotation(TestAnnotation.class);
                System.out.println(f.getName()+annotation.getColor()+"."+annotation.value());
            }
        }
    }
}
