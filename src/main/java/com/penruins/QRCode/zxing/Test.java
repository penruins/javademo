package com.penruins.QRCode.zxing;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.Result;
import com.google.zxing.WriterException;

import java.io.IOException;

public class Test {

  @org.junit.Test
  public void test() throws IOException, WriterException {
    String filePath = "src/main/resources/zxingQRCode.png";
    ZxingUtil.createQRcode(filePath);
  }

  @org.junit.Test
  public void test2() {
    Result result = ZxingUtil.getQRresult("src/main/resources/zxingQRCode.png");
    if (result != null) {
      System.out.println("二维码内容：" + result.getText());
      if (result.getText() != null) {
        FiveElements fiveElements = JSONObject.parseObject(result.getText(), FiveElements.class);
        System.out.println(fiveElements);
      }
      System.out.println("二维码格式：" + result.getBarcodeFormat());
    }
  }
}

