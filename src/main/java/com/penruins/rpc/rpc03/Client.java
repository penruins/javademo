package com.penruins.rpc.rpc03;

import com.penruins.rpc.common.IUserService;

public class Client {
    public static void main(String[] args)  {
        IUserService service = Stub.getStub();
        System.out.println(service.findUserByID(999)) ;
    }
}
