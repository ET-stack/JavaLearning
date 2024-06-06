package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
/**
 * @className: Kill
 * @description: TODO 类描述
 * @author: {yitao@flyread.com.cn}
 * @date: 2022/8/13
 **/
public class Kill {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        User user = new User();
        user.setName("Daisy");
        System.out.println("User：" + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(user));

        Map<String, Object> propertiesMap = new HashMap<>(1);
        Map<String, Object> childMap = new HashMap<>(1);
        childMap.put("a",11);
        propertiesMap.put("age", childMap);

        Object obj = ReflectUtil.getObject(user, propertiesMap);

        Field[]f2=obj.getClass().getDeclaredFields();
        for(Field field:f2) {
            System.out.println(field.getType().getName());

        }
        Field f1=obj.getClass().getDeclaredField("$cglib_prop_age");
        System.out.println(f1.get(obj));
        System.err.println("动态为User添加age之后，User：" + MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
    }
}

class DynamicBean {

    private Object target;

    private BeanMap beanMap;

    public DynamicBean(Class superclass, Map<String, Class> propertyMap) {
        this.target = generateBean(superclass, propertyMap);
        this.beanMap = BeanMap.create(this.target);
    }

    public void setValue(String property, Object value) {
        beanMap.put(property, value);
    }

    public Object getValue(String property) {
        return beanMap.get(property);
    }

    public Object getTarget() {
        return this.target;
    }

    /**
     * 根据属性生成对象
     */
    private Object generateBean(Class superclass, Map<String, Class> propertyMap) {
        BeanGenerator generator = new BeanGenerator();
        if (null != superclass) {
            generator.setSuperclass(superclass);
        }
        BeanGenerator.addProperties(generator, propertyMap);
        return generator.create();
    }
}

class ReflectUtil {

    public static Object getObject(Object dest, Map<String, Object> newValueMap) throws InvocationTargetException, IllegalAccessException {
        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();

        //1.获取原对象的字段数组
        PropertyDescriptor[] descriptorArr = propertyUtilsBean.getPropertyDescriptors(dest);

        //2.遍历原对象的字段数组，并将其封装到Map
        Map<String, Class> oldKeyMap = new HashMap<>(4);
        for (PropertyDescriptor it : descriptorArr) {
            if (!"class".equalsIgnoreCase(it.getName())) {
                oldKeyMap.put(it.getName(), it.getPropertyType());
                newValueMap.put(it.getName(), it.getReadMethod().invoke(dest));
            }
        }

        //3.将扩展字段Map合并到原字段Map中
        newValueMap.forEach((k, v) -> oldKeyMap.put(k, v.getClass()));

        //4.根据新的字段组合生成子类对象
        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), oldKeyMap);

        //5.放回合并后的属性集合
        newValueMap.forEach((k, v) -> {
            try {
                dynamicBean.setValue(k, v);
            } catch (Exception e) {
                System.err.println("动态添加字段【值】出错"+e);
            }
        });
        return dynamicBean.getTarget();
    }
}

class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}