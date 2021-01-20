package com.example.demoproject;

import lombok.Data;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Data
public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //如果是同一个对象返回true，反之返回false
        if (this == obj) {
            return true;
        }
        //判断是否类型相同
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return name.equals(person.name) && age == person.age;
    }

    /**
     * 50  * @desc重写hashCode
     * 51
     */
    @Override
    public int hashCode() {
        int nameHash = name.toUpperCase().hashCode();
        return nameHash ^ age;
    }

}
