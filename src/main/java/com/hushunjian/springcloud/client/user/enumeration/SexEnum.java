package com.hushunjian.springcloud.client.user.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
public enum SexEnum {

    MAN(1, "男性"),

    WOMAN(2, "女性");


    @Getter
    private int key;

    @Getter
    private String value;

    SexEnum (int key, String value) {
        this.key = key;
        this.value = value;
    }

}
