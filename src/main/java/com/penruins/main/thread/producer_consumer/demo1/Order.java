package com.penruins.main.thread.producer_consumer.demo1;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String commodityId;
    private String commodityName;
    private Double price;
    private Integer quantity;
}
