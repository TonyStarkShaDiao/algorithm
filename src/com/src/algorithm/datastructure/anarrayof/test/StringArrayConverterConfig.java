package com.src.algorithm.datastructure.anarrayof.test;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.Arrays;

/**
 * 字符串数组转换配置
 *
 * @author Tony Stark (沙雕) 13860120508
 * @date 2022/01/25
 */
public class StringArrayConverterConfig extends SimpleArgumentConverter {

    @Override 
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {

     if (source instanceof String && int[].class.isAssignableFrom(targetType)) {
         String[] split = ((String) source).split("\\s*;\\s*");
         return Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
     } else { 
      throw new IllegalArgumentException("Conversion from " + source.getClass() + " to " 
               + targetType + " not supported."); 
     } 
    } 

} 