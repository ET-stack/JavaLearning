package com.xiao;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author linjinjia
 * @date 2021/12/2 20:58 下午
 */
public class Ftl2DocTest {

    public static final String BASE_PACKAGE_DIR = "/static/exportTemplate";

    public static void main(String[] args) throws IOException {
        // 加载模版
        Configuration configuration = configuration();
        Template template = configuration.getTemplate("E:/Development/BackEnd/Java/Gitee/SpringBootLearning/springboot-freemarker/src/main/resources/templates/user.ftl");

        // 创建临时输出目录
        String dir = "/data/ftl2doc/export/doc-" + DateUtil.format(new Date(), "yyyyMMddHHmmss");
        FileUtil.mkdir(dir);

        // 模拟数据
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 25, DateUtil.parse("1997-04-07", "yyyy-MM-dd")));
        users.add(new User("李四", 26, DateUtil.parse("1996-01-09", "yyyy-MM-dd")));
        users.add(new User("王五", 27, DateUtil.parse("1995-09-08", "yyyy-MM-dd")));
        users.add(new User("赵六", 28, DateUtil.parse("1994-03-10", "yyyy-MM-dd")));

        // 简单的做法是把 JavaBean 转换为 Map，然后进行导出
        // data 的 key 作为输出文档的名称，value 是一个 bena 转化的 map，存储实体数据
        Map<String, Map<String, Object>> data = new HashMap<>();
        for(User user : users) {
            String docName = user.getUserName() + DateUtil.format(new Date(), DatePattern.PURE_DATETIME_PATTERN)+".doc";
            Map<String, Object> map = BeanUtil.beanToMap(user);
            data.put(docName, map);
        }

        // 输出
        data.forEach((docName, model) -> {
            try {
                File file = new File(dir, docName);
                FileWriter writer = new FileWriter(file);
                template.process(model, writer);
            } catch (Exception e) {
                // 输出错误日志，demo 直接简单打印到控制台
                e.printStackTrace();
            }
        });
    }

    public static freemarker.template.Configuration configuration() {
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassicCompatible(true);
        // 设置模版所在的目录，建议所有的模版都放在同一个目录下
        configuration.setClassForTemplateLoading(Ftl2DocTest.class, BASE_PACKAGE_DIR);
        return configuration;
    }


    static class User {
        private String userName;
        private Integer age;
        private Date birthday;

        public User(String userName, Integer age, Date birthday) {
            this.userName = userName;
            this.age = age;
            this.birthday = birthday;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }
    }
}
