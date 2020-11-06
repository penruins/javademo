package com.penruins.rpc.rpc07;

import com.penruins.rpc.common.IProductService;

public class Client {
    public static void main(String[] args)  {

        IProductService service = (IProductService) Stub.getStub(IProductService.class);
        System.out.println(service.findProductById(999)) ;
    }
}
