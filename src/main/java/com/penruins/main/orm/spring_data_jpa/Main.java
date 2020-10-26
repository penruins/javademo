package com.penruins.main.orm.spring_data_jpa;

/**
 * Spring Data JPA 是Spring基于ORM, JPA规范的基础上
 * 封装的一套JPA应用框架，可使得开发者用极简的代码对数据库
 * 进行访问和操作，它提供了包括增删改查在内的常用功能，且易于扩展
 * 学习并使用Spring Data JPA 可以极大提高开发效率
 *
 * Spring Data JPA 让我们解脱了DAO层的操作，基本上所有CRUD都可以依赖
 * 于它来实现，在实际的工作工程中，推荐使用Spring Data JPA + ORM（如hibernate）
 * 完成操作，这样在切换不同的ORM框架时提供了极大的方便，同时也使数据库操作
 * 更加简单，方便解耦
 *
 *
 * Spring Data JPA 与 JPA 和 hibernate 之间的关系
 *      JPA是一套规范，内部是有接口和抽象类组成的
 *
 *      hibernate是一套成熟的ORM框架，而且hibernate
 *      实现了JPA规范。所以也可以称hibernate为JPA的一种
 *      实现方式，我们使用JPA的API编程，意味着站在更高的角度
 *      看待问题（面向接口编程）
 *
 *      Spring Data JPA是Spring提供的一套对JPA操作更加高级的
 *      封装，是在JPA规范下的专门用来进行数据持久化的解决方案
 */
public class Main {
}
