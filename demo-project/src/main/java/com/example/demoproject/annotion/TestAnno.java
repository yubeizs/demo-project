package com.example.demoproject.annotion;

import com.example.demoproject.constant.TestConstant;
import com.example.demoproject.emun.TestEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface TestAnno {

    //多个或者多种过滤，也可以直接使用下面的单种
    String[] values() default {TestConstant.BOSS,TestConstant.STAFF};

//    String value();

}
