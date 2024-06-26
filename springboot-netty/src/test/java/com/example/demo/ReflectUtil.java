//package com.example.demo;
//import com.google.common.collect.Maps;
//import net.sf.cglib.beans.BeanGenerator;
//import net.sf.cglib.beans.BeanMap;
//import org.apache.commons.beanutils.PropertyUtilsBean;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
///**
// * @className: ReflectUtil
// * @description: TODO 类描述
// * @author: {yitao@flyread.com.cn}
// * @date: 2022/8/13
// **/
//
//
//
///**
// *@author
// *@date 2019/10/9
// *@description
// */
//public class ReflectUtil {
//
//    static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);
//
//    public static Object getTarget(Object dest, Map<String, Object> addProperties) {
//        // get property map
//        PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
//        PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(dest);
//        Map<String, Class> propertyMap = Maps.newHashMap();
//        for (PropertyDescriptor d : descriptors) {
//            if (!"class".equalsIgnoreCase(d.getName())) {
//                propertyMap.put(d.getName(), d.getPropertyType());
//            }
//        }
//        // add extra properties
//        for (Map.Entry<String, Object> entry : addProperties.entrySet()) {
//            propertyMap.put(entry.getKey(), entry.getValue().getClass());
//        }
////        addProperties.forEach((k, v) -> propertyMap.put(k, v.getClass()));
//        // new dynamic bean
//        DynamicBean dynamicBean = new DynamicBean(dest.getClass(), propertyMap);
//        // add old value
//        for (Map.Entry<String, Class> entry : propertyMap.entrySet()) {
//            try {
//                // filter extra properties
//                if (!addProperties.containsKey(entry.getKey())) {
//                    dynamicBean.setValue(entry.getKey(), propertyUtilsBean.getNestedProperty(dest, entry.getKey()));
//                }
//            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
//            }
//        }
//        ;
//        // add extra value
//        for (Map.Entry<String, Object> entry : addProperties.entrySet()) {
//            try {
//                dynamicBean.setValue(entry.getKey(), entry.getValue());
//            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
//            }
//        }
//        ;
//        Object target = dynamicBean.getTarget();
//        return target;
//    }
//
//    public static class DynamicBean {
//        /**
//         * 目标对象
//         */
//        private Object target;
//
//        /**
//         * 属性集合
//         */
//        private BeanMap beanMap;
//
//        public DynamicBean(Class superclass, Map<String, Class> propertyMap) {
//            this.target = generateBean(superclass, propertyMap);
//            this.beanMap = BeanMap.create(this.target);
//        }
//
//
//        /**
//         * bean 添加属性和值
//         *
//         * @param property
//         * @param value
//         */
//        public void setValue(String property, Object value) {
//            beanMap.put(property, value);
//        }
//
//        /**
//         * 获取属性值
//         *
//         * @param property
//         * @return
//         */
//        public Object getValue(String property) {
//            return beanMap.get(property);
//        }
//
//        /**
//         * 获取对象
//         *
//         * @return
//         */
//        public Object getTarget() {
//            return this.target;
//        }
//
//
//        /**
//         * 根据属性生成对象
//         *
//         * @param superclass
//         * @param propertyMap
//         * @return
//         */
//        private Object generateBean(Class superclass, Map<String, Class> propertyMap) {
//            BeanGenerator generator = new BeanGenerator();
//            if (null != superclass) {
//                generator.setSuperclass(superclass);
//            }
//            BeanGenerator.addProperties(generator, propertyMap);
//            return generator.create();
//        }
//    }
//
//    public static void main(String[] args) {
//        TestClass entity = new TestClass();
//        entity.setAge(15);
//        entity.setId(1);
//        entity.setName("张三");
//        //动态设置属性字段
//        Map<String, Object> addProperties = new HashMap() {{
//            put("sex", "男");
//            put("telephone", "123456789");
//        }};
//        //获取实体中给属性的值
//        Object target = getTarget(entity, addProperties);
//        System.out.println(getFieldValueByName("id", target));
//        System.out.println(getFieldValueByName("name", target));
//        System.out.println(getFieldValueByName("age", target));
//        System.out.println(getFieldValueByName("sex", target));
//        System.out.println(getFieldValueByName("telephone", target));
//    }
//
//    //获取实体中属性的值
//    private static Object getFieldValueByName(String fieldName, Object o) {
//        try {
//            //通过反射获取值
//            String firstLetter = fieldName.substring(0, 1).toUpperCase();
//            String getter = "get" + firstLetter + fieldName.substring(1);
//            Method method = o.getClass().getMethod(getter, new Class[]{});
//            Object value = method.invoke(o, new Object[]{});
//            return value;
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//            return null;
//        }
//    }
//
//    //测试类
//    public static class TestClass{
//        //ID
//        private int id;
//        //名字
//        private String name;
//        //年龄
//        private int age;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//    }
//
//}
//
//
