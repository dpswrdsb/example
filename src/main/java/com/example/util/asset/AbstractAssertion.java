package com.example.util.asset;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @ClassName: AbstractAssertion
 * @Description:
 * @Author: Mr.Wang <a href="mailto:15998593797@163.com">发送邮件</a>
 * @Date: 2020-05-10 11:30
 */
public class AbstractAssertion extends Assert {

    public static final String EMPTY_STRING = StringUtils.EMPTY;

    /**
     * 负数
     * @param value 数值
     * @return true OR false
     */
    public static boolean isNegative(double value) {
        return value < 0;
    }

    /**
     * 正数
     * @param value 数值
     * @return true OR false
     */
    public static boolean isPositive(double value) {
        return value > 0;
    }

    /**
     * 非空
     * @param array String数组
     * @return true OR false
     */
    public static boolean notEmpty(String[] array) {
        return null != array && array.length > 0;
    }

    /**
     * 非空
     * @param bytes byte数组
     * @return true OR false
     */
    public static boolean notEmpty(byte[] bytes) {
        return (null != bytes && 0 < bytes.length);
    }

    /**
     * 非空
     * @param array byte数组
     * @return true OR false
     */
    public static boolean notEmpty(long[] array) {
        return null != array && array.length > 0;
    }

    /**
     * 非空
     * @param array int数组
     * @return true OR false
     */
    public static boolean notEmpty(int[] array) {
        return null != array && array.length > 0;
    }

    /**
     * 非空
     * @param array short数组
     * @return true OR false
     */
    public static boolean notEmpty(short[] array) {
        return null != array && array.length > 0;
    }

    /**
     * 非空
     * @param list list集合
     * @return true OR false
     */
    public static boolean notEmpty(List<?> list) {
        return null != list && !list.isEmpty();
    }

    /**
     * 非空
     * @param string 字符串
     * @return true OR false
     */
    public static boolean notEmpty(String string) {
        return null != string && !EMPTY_STRING.equals(string.trim());
    }

    /**
     * list集合只有一条
     * @param list 结合
     * @return true OR false
     */
    public static boolean onlyOne(List<?> list) {
        return notEmpty(list) && list.size() == 1;
    }

    /**
     * 校验value是否是纯数字
     * @param value 字符串
     */
    public static boolean isDigits(String value) {
        return NumberUtils.isDigits(value);
    }

    /**
     * 校验value的长度是否大于length
     * @param value 字符串
     * @param length 长度
     */
    public static boolean greaterThanLength(String value, int length) {
        return  value.length()  > length;
    }

    /**
     * 校验value的长度是否大于等于length
     * @param value 字符串
     * @param length 长度
     */
    public static boolean greaterThanOrEqualLength(String value, int length) {
        return value.length() >= length;
    }

    /**
     * 校验value的长度是否小于length
     * @param value 字符串
     * @param length 长度
     */
    public static boolean lessThanLength(String value, int length) {
        return value.length() < length;
    }

    /**
     * 校验value的长度是否小于等于length
     * @param value    字符串
     * @param length   长度
     */
    public static boolean lessThanOrEqualLength(String value, int length) {
        return value.length() <= length;
    }

    /**
     * 校验value长度是否在开区间内
     * @param value 字符串
     * @param min  最小长度
     * @param max  最大长度
     */
    public static boolean betweenLength(String value, int min, int max) {
        return value.length() >= min && value.length() <= max;
    }

    /**
     * 校验value长度是否在闭区间内
     * @param value 字符串
     * @param min 最小长度
     * @param max 最大长度
     */
    public static boolean betweenOrEqualLength(String value, int min, int max) {
        return value.length() > min && value.length() < max;
    }

    /**
     * 校验value的字节长度是否小于等于length
     * @param value 字符串
     * @param length 长度
     */
    public static boolean lessThanOrEqualLengthInByte(String value, int length) {
        return value.getBytes().length <= length;
    }
}
