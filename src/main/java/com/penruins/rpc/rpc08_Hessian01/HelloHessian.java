package com.penruins.rpc.rpc08_Hessian01;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.penruins.rpc.common.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HelloHessian {
  public static void main(String[] args) throws IOException {
    User u = new User(1,"penruins");
    byte[] bytes = serizlize(u);
    System.out.println(bytes.length);
    User u1 = (User) deserialize(bytes);
    System.out.println(u1);
  }

  private static byte[] serizlize(Object o) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    Hessian2Output output = new Hessian2Output(baos);
    output.writeObject(o);
    output.flush();
    byte[] bytes = baos.toByteArray();
    baos.close();
    output.close();
    return bytes;
  }

  private static Object deserialize(byte[] bytes) throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
    Hessian2Input input = new Hessian2Input(bais);
    Object o = input.readObject();
    bais.close();
    input.close();
    return o;
  }
}
