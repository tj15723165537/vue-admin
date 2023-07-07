package com.example.serve.enums;

public enum WhetherEnum {
   
    YES(1, "是"),
 
    NO(0, "否");

    private Integer code;

    private String desc;

    public Integer code() {
        return this.code;
    }

    public String desc() {
        return this.desc;
    }

    WhetherEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Integer getCode(String desc) {
        WhetherEnum[] values = values();
        for (WhetherEnum value : values) {
            if (value.desc().equals(desc)) {
                return value.code();
            }
        }
        return null;
    }

    public static String getDesc(Integer code) {
        WhetherEnum[] values = values();
        for (WhetherEnum value : values) {
            if (value.code().equals(code)) {
                return value.desc();
            }
        }
        return null;
    }


}
