package com.penruins.orm;


import com.penruins.orm.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * 测试jpql查询 Java Persistence Query Language
 */
public class JpqlTest {
    /**
     * 查询全部
     */
    @Test
    public void testFindAll() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        /**
         * idea中使用JPA出现from unexpected或者属性名 can't resolve 错误
         *      同时添加hibernate 和 j2EE persistence 的框架支持
         *      add framework support
         *
         *  其实这种下划线红色一般对程序没什么影响，照常能正常运行
         */

        //也不一定用全限定类名
        String jpql = "from com.penruins.main.orm.domain.Book";
        Query query = em.createQuery(jpql);
        List list = query.getResultList();
        list.forEach(System.out::println);
        tx.commit();
        em.close();
    }

    /**
     * 排序查询：倒序查询全部客户（根据id倒序）
     */
    @Test
    public void testOrders() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql = "from Book order by id desc";
        Query query = em.createQuery(jpql);
        List list = query.getResultList();
        list.forEach(System.out::println);
        tx.commit();
        em.close();
    }

    /**
     * 统计book的总数
     */
    @Test
    public void testCount() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql = "select count(id) from Book";
        Query query = em.createQuery(jpql);
        Object result = query.getSingleResult();
        System.out.println(result);
        tx.commit();
        em.close();
    }

    /**
     * 分页查询
     */
    @Test
    public void testPaged() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql = "from Book";
        Query query = em.createQuery(jpql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List list =  query.getResultList();
        list.forEach(System.out::println);
        tx.commit();
        em.close();
    }

    /**
     * 条件查询
     *
     */
    @Test
    public void testCondition() {
        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String jpql = "from Book where name like ?";
        Query query = em.createQuery(jpql);
        query.setParameter(1,"%主义%");
        List list =  query.getResultList();
        list.forEach(System.out::println);
        tx.commit();
        em.close();
    }
}






























