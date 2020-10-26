package com.penruins.rpc.rpc03;

import com.penruins.rpc.common.IUserService;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Stub stub = new Stub();
        System.out.println(stub.findUserById(555));

        IUserService service = Stub.getStub();
        System.out.println(service.findUserByID(999));
    }
}
