package com.example.demoproject.emun;

public enum TestEnum {

    BOSS("boss","老板"),
    STAFF("staff","员工");


    private String code;
    private String name;

    TestEnum(String code) {
        this.code = code;
    }

    TestEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
