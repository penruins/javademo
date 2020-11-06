package com.penruins.QRCode;

import java.io.IOException;

/**
 * 生成二维码
 *
 * 生成图片的路径
 */
public class Test {
  public static void main(String[] args) throws IOException {
    String imgPath = "src/main/resources/QRCode.png";
    String content = "这是老子刚刚用java生成的二维码";
    QRCodeUtil.encoderQRCode(content,imgPath,"png",7);
  }



}
