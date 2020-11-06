package com.penruins.rpc.rpc07;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    public static Object getStub(Class clazz) {
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1",8888);
                String clazzName = clazz.getName();
                String methodNmae = method.getName();
                Class[] parametersTypes = method.getParameterTypes();
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeUTF(clazzName);
                oos.writeUTF(methodNmae);
                oos.writeObject(parametersTypes);
                oos.writeObject(args);
                oos.flush();


                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Object o = ois.readObject();

                oos.close();
                s.close();

                return o;
            }
        };
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},h);
        return o;
    }
}
