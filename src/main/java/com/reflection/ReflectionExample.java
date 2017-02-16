package com.reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ReflectionExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        RentCar rentCar = generateBean(RentCar.class);
        System.out.println(rentCar.toString());
    }

    public static <T> T generateBean(Object bean) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class clazz = bean.getClass();
        Object obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        TypeVariable[] typeParameters = clazz.getTypeParameters();
        Map<String, String> kvs = new HashMap<>();
        kvs.put("price", "50");
        kvs.put("type", "B");
        kvs.put("rate", "1.09");
        Arrays.stream(fields).parallel().forEach((field) -> {
            String name  = field.getName();
            if (kvs.get(name)!=null) {
                Method method = null;
                try {
                    method = clazz.getMethod(name, field.getType());
                    method.invoke(name, kvs.get(field.getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            };
        });
        return (T) clazz;
    }

    public static String parseSetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return "set" + fieldName.substring(0, 1).toUpperCase()
                + fieldName.substring(1);
    }

    public static boolean checkSetMethod(Method[] methods, String fieldSetMet) {
        for (Method met : methods) {
            if (fieldSetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }
}