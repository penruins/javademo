package com.penruins.rpc.rpc05;

import com.penruins.rpc.common.IUserService;
import com.penruins.rpc.common.User;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class Stub {

    public static IUserService getStub() {
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket s = new Socket("127.0.0.1",8888);
                String methodNmae = method.getName();
                Class[] parametersTypes = method.getParameterTypes();
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeUTF(methodNmae);
                oos.writeObject(parametersTypes);
                oos.writeObject(args);
                oos.flush();


                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                User user = (User) ois.readObject();

                oos.close();
                s.close();

                return user;
            }
        };
        Object o = Proxy.newProxyInstance(IUserService.class.getClassLoader(),new Class[]{IUserService.class},h);
        return (IUserService) o;
    }
}
