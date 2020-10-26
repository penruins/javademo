package com.penruins.rpc.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;



@Data
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String name;
}
