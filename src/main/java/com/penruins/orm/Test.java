package com.penruins.orm;

import com.penruins.orm.domain.Book;
import com.penruins.orm.utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
    /**
     * 测试jpa的保存
     *  案例：保存一个客户到数据库中
     */
    @org.junit.Test
    public void testSave() {
        /**
         * 加载配置文件创建工厂（实体管理器工厂）对象
         *
         * 内部维护了很多内容
         *      内部维护了数据库信息
         *      维护了缓存信息
         *      维护了所有的实体管理器对象
         *
         *
         *  EntityManagerFactory 创建过程比较浪费资源
         *  特点：
         *      线程安全的对象
         *      多个线程访问同一个EntityManagerFactory不会有线程安全的问题
         *
         *  如何解决EntityManagerFactory的创建过程浪费资源（耗时）的问题？
         *      创建一个公共的EntityManagerFactory的对象
         *      静态代码的形式创建
         */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //通过实体管理器工厂获取实体管理器
        EntityManager em = factory.createEntityManager();
        //获取事务对象，开启事务
        /**
         * begin 开启事务
         * commit 提交事务
         * rollback 回滚
         */
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //完成增删查改操作: 保存一个客户到数据库中
        Book book = new Book();
        book.setAmount(1000);
        book.setAuthor("大卫休谟");
        book.setBookDescription("所有印象无不来自于感觉之中");
        book.setName("人类理智研究");
        book.setPress("商务印书馆");
        book.setPrice(99.5);
        book.setType(2);
        /**
         * persist 保存
         * merge 更新
         * remove 删除
         * find/getReference 根据id查询
         */
        //保存
        em.persist(book);
        tx.commit();
        //释放资源
        em.close();
        factory.close();
    }


    /**
     * 根据id查询客户
     */
    @org.junit.Test
    public void testFind() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        /**
         * 根据id查询数据
         *      class 查询数据的结果需要包装的实体类类型的字节码
         *      id  查询的主键的取指
         */
        Book book = entityManager.find(Book.class,15);
        System.out.println(book);
        tx.commit();
        entityManager.close();

    }

    @org.junit.Test
    public void testRerefence() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        /**
         * 使用find方法查询
         *      查询的对象就是当前客户对象本身
         *      在调用find方法的时候，就会发出sql语句查询数据库
         *
         *
         * getReference
         *      获取的对象是一个动态代理对象
         *      调用getReference方法不会立即发送sql语句查询数据库
         *      当调用查询结果对象的时候，才会发送查询的sql语句
         *      什么时候用，什么时候发送sql语句查询数据库
         *
         */
        Book book = entityManager.getReference(Book.class,15);
        System.out.println(book);
        tx.commit();
        entityManager.close();
    }


    /**
     * 删除操作
     */
    @org.junit.Test
    public void testRemove() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Book book = entityManager.find(Book.class,28);
        entityManager.remove(book);
        tx.commit();
        entityManager.close();
    }

    /**
     * 更新操作
     */
    @org.junit.Test
    public void testUpdate() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Book book = entityManager.find(Book.class,37);
        book.setPress("商务印书馆");
        entityManager.merge(book);
        tx.commit();
        entityManager.close();
    }

}


















