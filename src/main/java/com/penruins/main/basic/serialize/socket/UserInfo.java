package com.penruins.main.basic.serialize.socket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserInfo implements Serializable {
    private int age;
    private String name;
}
