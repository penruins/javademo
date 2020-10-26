package com.penruins.main.orm;

/**
 * orm思想 Object Relational Mapping 对象关系映射
 * 主要目的：操作实体类就相当于操作数据库表
 * 建立两个映射关系：
 *      实体类和表的映射关系
 *      实体类中属性和表中字段的映射关系
 *  不再重点关注： sql语句
 *
 *  实现了ORM思想的框架：mybatis，hibernate
 *
 *
 *
 *
 *  jpa规范
 *      实现jpa规范，内部是由接口和抽象类组成
 *
 *      Java Persistence API 即Java持久化API，是SUN公司
 *      退出的一套基于ORM的规范，内部有一系列的接口和抽象类构成
 *
 *      JPA通过JDK 5.0 注解描述对象-关系表的映射关系
 *      并将运行期的实体对象持久化到数据库
 *
 *      javax.persistence.Entity
 *
 *
 *
 *  配置jpa的核心配置文件
 *      配置到类路径下一个叫做META-INF的文件夹下
 *      命名 persistence.xml
 */
public class Main {
}
