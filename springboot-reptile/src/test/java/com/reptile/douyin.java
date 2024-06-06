package com.reptile;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class douyin {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person1 = new Person();
        Person person = person1;
        Field[] fields = person.getClass().getFields();

        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println( ((Person.Persons) Person.Persons.PERSONS1.getClass().getField("PERSONS1").get("")));
    }

}


class Person {
    public  enum Persons{
        PERSONS("sss"),

        PERSONS1("sss1");
        private final String name;
        Persons(String s) {
            name = s;
        }


        @Override
        public String toString() {
            return "Persons{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
