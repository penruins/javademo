package com.penruins.rpc.rpc06;

import com.penruins.rpc.common.IUserService;

public class Client {
    public static void main(String[] args)  {
        IUserService service = (IUserService) Stub.getStub(IUserService.class);
        System.out.println(service.findUserByID(999)) ;
    }
}
