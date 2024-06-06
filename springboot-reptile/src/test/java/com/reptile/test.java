package com.reptile;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.Collator;
import java.util.*;

/**
 * @className: test
 * @description: TODO 类描述
 * @author:
 * @date: 2022/11/16
 **/
public class test {

    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        List<Student> studentList = new LinkedList<>();
        studentList.add(new Student(1, "小1", 22));
        studentList.add(new Student(9, "小9", 22));
        studentList.add(new Student(2, "小2", 22));
        String getMethodName = "get" + "id".substring(0, 1).toUpperCase() + "id".substring(1);
        Map<Object, Student> orderByMap = new IdentityHashMap<>();
      List<Student> returnList =   orderForList(studentList,1,"name");

      returnList.stream().forEach(Student::getName);

    }

    /**
     * list对对象中的字段进行排序
     * @param list 待排序的列表
     * @param orderType 排序{0,无序，1,ASC升序;2,DESC降序}
     * @param orderByName 实体排序的字段
     * */
    public static  <T> List<T> orderForList(List<T> list, Integer orderType, String orderByName) {
        long startTime = System.currentTimeMillis();
        // 不需要排序
        if(orderType == 0){
            return list;
        }
        if(list == null || list.size() <= 1){
            return list;
        }
        //首字母转大写
        String newStr = orderByName.substring(0, 1).toUpperCase() + orderByName.replaceFirst("\\w", "");
        String methodStr = "get" + newStr;
        Field declaredField = null;
        boolean stringType = true ;
        // 排序类型的获取
        try {
            declaredField = list.get(0).getClass().getDeclaredField(orderByName);
            Class<?> type = declaredField.getType();
            if(type.equals(Integer.class) || type.equals(Float.class) || type.equals(Double.class) || type.equals(BigDecimal.class)){
                stringType = false;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        final boolean flag = stringType ;

        Collections.sort(list, new Comparator<T>() {
            @Override
            public int compare(T obj1, T obj2) {
                int retVal = 0;
                try {
                    Method method1 = ((T) obj1).getClass().getMethod(methodStr, null);
                    Method method2 = ((T) obj2).getClass().getMethod(methodStr, null);
                    // 倒序
                    if (orderType == 2 ) {
                        // 是否按字符串比较
                        if(flag) {
                            // 字符串按 中英文 排序方式
                            Comparator<Object> chinaSort = Collator.getInstance(Locale.CHINA);
                            retVal = ((Collator) chinaSort).compare(method2.invoke(((T) obj1), null).toString(),method1.invoke(((T) obj2), null).toString());
//                            retVal = method2.invoke(((T) obj2), null).toString().compareTo(method1.invoke(((T) obj1), null).toString());
                        }else {
                            retVal = Double.valueOf(method2.invoke(((T) obj2), null).toString()).compareTo(Double.valueOf(method1.invoke(((T) obj1), null).toString()));
                        }
                    }
                    // 正序
                    if (orderType == 1) {
                        if(flag) {
                            // 字符串按 中英文 排序方式
                            Comparator<Object> chinaSort = Collator.getInstance(Locale.CHINA);
                            retVal = ((Collator) chinaSort).compare(method1.invoke(((T) obj1), null).toString(),method2.invoke(((T) obj2), null).toString());
//                            retVal = method1.invoke(((T) obj1), null).toString().compareTo(method2.invoke(((T) obj2), null).toString());
                        }else {
                            retVal = Double.valueOf(method1.invoke(((T) obj1), null).toString()).compareTo(Double.valueOf(method2.invoke(((T) obj2), null).toString()));
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return retVal;
            }
        });
        return list;
    }

}
