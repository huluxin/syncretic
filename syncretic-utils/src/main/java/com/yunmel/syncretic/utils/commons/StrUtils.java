/*
 * Copyright (c) 2016 yunmle.com(四川云麦尔科技).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yunmel.syncretic.utils.commons;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * 
 * @description 字符串工具类
 *
 * @author xuyq - chainisit@126.com
 * @since 1.0 - 2016年7月15日
 */
public class StrUtils extends StringUtils {
  /**
   * 转换为Double类型
   */
  public static Double toDouble(Object val) {
    if (val == null) {
      return 0D;
    }
    try {
      return Double.valueOf(trim(val.toString()));
    } catch (Exception e) {
      return 0D;
    }
  }

  /**
   * 转换为Float类型
   */
  public static Float toFloat(Object val) {
    return toDouble(val).floatValue();
  }

  /**
   * 转换为Long类型
   */
  public static Long toLong(Object val) {
    return toDouble(val).longValue();
  }

  /**
   * 转换为Integer类型
   */
  public static Integer toInteger(Object val) {
    return toLong(val).intValue();
  }

  /**
   * 将驼峰风格替换为下划线风格
   */
  public static String camelhumpToUnderline(String str) {
    final int size;
    final char[] chars;
    final StringBuilder sb =
        new StringBuilder((size = (chars = str.toCharArray()).length) * 3 / 2 + 1);
    char c;
    for (int i = 0; i < size; i++) {
      c = chars[i];
      if (isLowercaseAlpha(c)) {
        sb.append(toUpperAscii(c));
      } else {
        sb.append('_').append(c);
      }
    }
    return sb.charAt(0) == '_' ? sb.substring(1) : sb.toString();
  }

  /**
   * 将下划线风格替换为驼峰风格
   */
  public static String underlineToCamelhump(String name) {
    if (!name.contains("_"))
      return name;
    char[] buffer = name.toCharArray();
    int count = 0;
    boolean lastUnderscore = false;
    for (int i = 0; i < buffer.length; i++) {
      char c = buffer[i];
      if (c == '_') {
        lastUnderscore = true;
      } else {
        c = (lastUnderscore && count != 0) ? toUpperAscii(c) : toLowerAscii(c);
        buffer[count++] = c;
        lastUnderscore = false;
      }
    }
    if (count != buffer.length) {
      buffer = subarray(buffer, 0, count);
    }
    return new String(buffer);
  }

  /**
   * 截取字符串
   * @param src 源字符串
   * @param offset 开始位置
   * @param len 长度
   * @return 字符数组
   *      char[]
   */
  public static char[] subarray(char[] src, int offset, int len) {
    char[] dest = new char[len];
    System.arraycopy(src, offset, dest, 0, len);
    return dest;
  }

  public static boolean isLowercaseAlpha(char c) {
    return (c >= 'a') && (c <= 'z');
  }
  /**
   * 转换为大写字母
   * @param c 源字母
   * @return char
   */
  public static char toUpperAscii(char c) {
    if (isLowercaseAlpha(c)) {
      c -= (char) 0x20;
    }
    return c;
  }

  /**
   * 转换为小写字母
   * @param c
   * @return
   */
  public static char toLowerAscii(char c) {
    if ((c >= 'A') && (c <= 'Z')) {
      c += (char) 0x20;
    }
    return c;
  }

  /**
   * 类型转换
   * @param s
   * @return
   */
  public static String typeCovert(String s) {
    s = s.toLowerCase();
    if ("string".equals(s)) {
      return "java.lang.String";
    } else if ("long".equals(s)) {
      return "java.lang.Long";
    } else if ("int".equals(s) || "integer".equals(s)) {
      return "java.lang.Integer";
    } else if ("date".equals(s)) {
      return "java.util.Date";
    }
    return "java.lang.String";
  }

  public static Long[] toLongArray(String idStr, String separator) {
    if (StringUtils.isNotBlank(idStr)) {
      String[] ids = idStr.split(separator);
      List<Long> values = Lists.newArrayList();
      for (String id : ids) {
        if (StringUtils.isNotBlank(id)) {
          values.add(Long.valueOf(id));
        }
      }
      return values.toArray(new Long[0]);
    }
    return null;
  }

  /**
   * 首字母大写
   * @param str
   * @return
   */
  public static String firstCharToUpper(String str) {
    StringBuffer sb = new StringBuffer(str);
    sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
    return sb.toString();
  }

  /**
   * 首字母小写
   * @param str
   * @return
   */
  public static String firstCharToLower(String str) {
    StringBuffer sb = new StringBuffer(str);
    sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
    return sb.toString();
  }
  
  /**
   * 首字母大写
   * @param s 源字符串
   * @return
   */
  public static String firstCharToUpperCase(String s) {
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  /**
   * 首字母小写
   * @param s 源字符串
   * @return
   */
  public static String firstCharToLowerCase(String s) {
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }
}
