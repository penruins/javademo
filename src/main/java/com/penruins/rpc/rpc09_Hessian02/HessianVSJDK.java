package com.penruins.rpc.rpc09_Hessian02;

import com.caucho.hessian.io.Hessian2Output;
import com.penruins.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HessianVSJDK {
  public static void main(String[] args) throws IOException {
    User u = new User(1,"penruins");
    System.out.println("hessian:" + hessianSerizlize(u).length);
    System.out.println("jdk:" + jdkSerialize(u).length);
  }

  private static byte[] jdkSerialize(Object o) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream output = new ObjectOutputStream(baos);
    output.writeObject(o);
    output.flush();
    byte[] bytes = baos.toByteArray();
    baos.close();
    output.close();
    return bytes;
  }

  private static byte[] hessianSerizlize(Object o) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    Hessian2Output output = new Hessian2Output(baos);
    output.writeObject(o);
    output.flush();
    byte[] bytes = baos.toByteArray();
    baos.close();
    output.close();
    return bytes;
  }
}
