package com.penruins.proxy.static_proxy.merchant;

/**
 * 静态代理的特点：实现简单 容易理解
 * 缺点  当你的项目中，目标类和代理类很多的时候，有以下的缺点
 *     当目标类增加了，代理类可能也需要成倍的增加。代理类数量过多
 *     当你的接口中功能增加了，或者修改了，会影响众多的实现类，厂家类，代理都需要修改，影响比较多
 *
 *
 *
 * 动态代理：在静态代理中目标类很多的时候，可以使用动态代理，避免静态代理的缺点。动态代理中目标类即使很多，代理类数量可以很少，当你修改了接口中的方法时
 *         不会影响代理类
 *
 *          在程序执行过程中，使用jdk的反射机制，来创建创建代理类对象，并动态地指定要代理的目标类
 *          换句话说，动态代理是一种创建java对象的能力，让你不用创建Taobao类，就能创建代理类对象
 *
 *          在java中，要想创建对象
 *              1. 创建类文件，java文件编译为class
 *              2. 使用构造方法，创建类的对象
 *
 *
 * 动态代理的实现
 *        1. jdk动态代理 使用java反射包中的类和接口实现动态代理的功能 反射包java.lang.refelct 里面有三个类 InvocationHandler Method Proxy
 *           类必须要有接口
 *        2. cglib（Code Generation Library）动态代理 第三方的工具库，能够创建对象 cglib的原理是继承，它通过继承目标类，创建它的子类，在子类中重写父类中同名的方法，实现功能的修改
 *           因为cglib是继承，重写方法，所以要求目标类不能是final的，方法也不能是final的
 *           cglib的要求目标类比较宽松，只要能继承就可以了。cglib在很多的框架中使用，比如mybatis spring框架中，都有所使用
 *
 *
 *
 *
 * InvocationHandler(调用处理器) 接口 就一个方法 invoke() 表示代理对象要执行的功能代码。你的代理类要完成的功能就写在invoke()方法中
 *    代理类完成的功能： 1. 调用目标方法，执行目标方法的功能 2. 功能增强，在目标方法调用时，增加功能
 *
 *
 *   方法原型
 *      public Object invoke(Object proxy,Method method, Object[] args)
 *
 *        Object proxy jdk创建的代理对象，无需赋值
 *        Method method 目标类中的方法，jdk提供method对象的
 *        Object[] args 目标类中方法的参数，jdk提供的
 *
 *
 *      怎么用： 1. 创建类实现接口InvocationHandler 2. 重写invoke方法，把原来静态代理类中要完成的功能，写到这里
 *
 *
 *
 * Method类：表示方法的，确切的说就是目标类中的方法。通过Method可以执行某个类的方法
 * Proxy类： 核心的对象，创建代理对象。之前创建对象都是new类的构造方法，现在我们是使用Proxy类的方法，代替new的使用
 *            方法： 静态方法 newProxyInstance()
 *
 *                public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h)
 *
 *                参数：
 *                    1. ClassLoader loader 类加载器，负责向内存中加载对象。使用反射获取对象的ClassLoader
 *                        类a  a.getClass().getClassLoader() 目标对象的类加载器
 *                    2. Class<?>[] interfaces 接口，目标对象实现的接口，也是反射获取的
 *                    3. InvocationHandler h 我们自己写的，代理类要完成的功能
 *
 *                返回值：就是代理对象
 *
 *  实现动态代理的步骤
 *      1. 创建接口，定义目标类要完成的功能
 *      2. 创建目标类实现接口
 *      3. 创建invocationHandler接口的实现类，在invoke方法中完成代理类的功能
 *        1. 调用目标方法
 *        2. 功能增强
 *      4. 使用Proxy类的静态方法，创建代理对象，并把返回值转为接口类型
 */


import com.penruins.proxy.static_proxy.USBSell;
import com.penruins.proxy.static_proxy.factory.USBKingFactory;

/**
 * 淘宝是一个商家，代理金士顿U盘的销售
 *
 *
 * 代理类完成的功能
 *    目标类中方法的调用
 *    功能增强
 */
public class Taobao implements USBSell {

  private USBKingFactory factory = new USBKingFactory(); //声明 商家代理的厂家是谁

  /**
   * 实现销售U盘的功能
   * @param amount 表示一次购买的数量
   * @return
   */
  @Override
  public float sell(int amount) {
    float price = factory.sell(amount);//向厂家发送订单，告诉厂家，我买了U盘，厂家发货
    /**
     * 商家 需要加价，也就是代理要增加价格
     *
     * 增强功能，代理类在完成目标类方法调用后
     * 增强了功能
     */
    price = price + 25;

    System.out.println("淘宝商家，给你返了一个优惠券，或者红包");

    return price;//增加的价格
  }
}
