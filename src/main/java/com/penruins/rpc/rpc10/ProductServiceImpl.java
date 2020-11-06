package com.penruins.rpc.rpc10;

import com.penruins.rpc.common.IProductService;
import com.penruins.rpc.common.Product;

public class ProductServiceImpl implements IProductService {
  @Override
  public Product findProductById(Integer id) {
    return new Product(id,"MacBook Pro");
  }
}
