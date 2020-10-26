package com.penruins.main.reflection;

import java.lang.reflect.Field;

public class PropertyUtil {


    public static void setProperty(Object obj,String propertyName,Object value) {
        Class<?> clazz = obj.getClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField(propertyName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.set(obj,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
