package com.reptile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @className: jsonTest
 * @description: TODO 类描述
 * @author: 
 * @date: 2022/12/1
 **/
public class jsonTest {
    static class Student {
        String username;
        String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public static void main(String[] args) throws IOException {
            String jsonStr = "[\n" +
                    "  {\n" +
                    "  \"username\":\"11\",\"password\":\"212\"\n" +
                    "},{\n" +
                    "  \"username\":\"11\",\"password\":\"212\"\n" +
                    "},{\n" +
                    "  \"username\":\"11\",\"password\":\"212\"\n" +
                    "}]";
            ObjectMapper objectMapper = new ObjectMapper();
         //第一种办法
            CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Student.class);
            List<Student>   studentList = objectMapper.readValue(jsonStr, listType);

            //第二种
            Student student  = objectMapper.convertValue(studentList.get(0),Student.class);
            System.out.println(studentList);
        }
    }
}
