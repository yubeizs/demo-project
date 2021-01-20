package com.example.demoproject.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ConstraintImpl implements ConstraintValidator<ValidIDCard,Object> {

    private static final String IDCard18 = "[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]";
    private static final String IDCard15 = "[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}";

    @Override
    public void initialize(ValidIDCard constraintAnnotation) {
        // 获取注解值中的value，如果有需要的话可以进行处理，比如Max,Min 就需要
        System.out.println("校验身份证号初始化~~~");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern ;
        if(o instanceof  String){
            String str = (String)o;
            if(str.length()==18){
                pattern = Pattern.compile(IDCard18);
                return pattern.matcher(str).matches();
            }
            if(str.length()==15){
                pattern = Pattern.compile(IDCard15);
                return pattern.matcher(str).matches();
            }
        }
        return false;
    }
}
