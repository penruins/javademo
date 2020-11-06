package com.penruins.reflection.rpc.client;

public class Client<T> {
    /**
     * 获取代表服务端接口的动态代理对象
     * @param serviceInterface 请求的接口名
     * @param address 待请求服务端的ip和端口号
     * @return T
     */
//    public T getRemoteProxyObj(Class serviceInterface, InetSocketAddress address) {
//        /**
//         * newProxyInstance(a,b,c)
//         * a 类加载器 需要代理哪个类
//         * b 需要代理的对象，具备哪些功能 接口
//         */
//        return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader(),
//                new Class<?>[]{serviceInterface}, new InvocationHandler() {
//                    /**
//                     *
//                     * @param proxy 代理的对象
//                     * @param method 代理哪个方法
//                     * @param args 参数列表
//                     * @return
//                     * @throws Throwable
//                     */
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        /**
//                         * 客户端向服务端发送请求
//                         * 请求某一个具体的接口
//                         */
//                        Socket socket = new Socket();
//                        socket.connect(address);
//                        ObjectOutputStream output = new ObjectOutputStream(
//                                socket.getOutputStream()); //发送：序列化流（对象流）
//
//                        /**
//                         * 需要发送什么
//                         *      接口名 writeUTF
//                         *      方法名 writeUTF
//                         *      方法参数的类型
//                         *      方法参数
//                         */
//                        output.writeUTF(serviceInterface.getName());
//                        output.writeUTF(method.getName());
//
//                    }
//                });
//    }
}
