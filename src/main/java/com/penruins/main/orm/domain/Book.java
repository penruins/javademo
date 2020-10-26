package com.penruins.main.orm.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity // 声明实体类
@Table(name = "book2") //配置实体类和表的映射关系
public class Book {

    @Id //声明主键的配置
    /**
     * 配置主键的生成策略
     * GenerationType.IDENTITY 自增
     *    底层数据库必须支持自动增长
     * GenarationType.SEQUENCE 序列
     *    底层数据库必须支持序列 oracle
     *  GenarationType.TABLE jpa提供的一种机制
     *    通过一张数据库表的形式帮助我们完成主键自增
     * GenarationType.AUTO 由程序自动的帮助我们选择生成策略
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //配置属性和字段的映射关系
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private int type;

    @Column(name = "author")
    private String author;

    @Column(name = "press")
    private String press;

    @Column(name = "price")
    private Double price;

    @Column(name = "bookDescription")
    private String bookDescription;

    @Column(name = "amount")
    private int amount;
}
