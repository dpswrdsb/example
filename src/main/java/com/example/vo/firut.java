package com.example.vo;

import com.example.util.annotation.TestAnnotation;
import lombok.Data;

@Data
public class firut {
    @TestAnnotation("Apple")
    public String name;
    @TestAnnotation(getColor = TestAnnotation.color.Blue)
    public String color;
    @Override
    public String toString() {
        return "firut{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
