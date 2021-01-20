package com.example.demoproject.dto;

import com.example.demoproject.valid.ValidIDCard;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ValidDTO {

    @NotNull(message = "名称不能为空")
    String name;

    @ValidIDCard(message = "身份证号格式不对~")
    String idCard;

    String age;

}
