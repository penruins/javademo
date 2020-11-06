package com.penruins.QRCode;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeUtil {
  public static void encoderQRCode(String content,String imgPath,String imgType,int size) throws IOException {
    File file = new File(imgPath);
    BufferedImage bufferedImage = qrCodeCommon(content,imgType,size);
    ImageIO.write(bufferedImage,imgType,file);
  }

  /**
   *
   * @param content 二维码中隐藏的信息
   * @param imgType 图片格式
   * @param size 图片大小
   * @return
   */
  private static BufferedImage qrCodeCommon(String content,String imgType,int size) {
    BufferedImage bufferedImage = null;

    Qrcode qrcodeHandler = new Qrcode(); //string->boolean[][]
    /**
     * 设置二维码的排错率： 7<L<M<Q<30
     * 排错率越高，可存储的信息越少，但是对二维码清晰度要求越小
     */
    qrcodeHandler.setQrcodeErrorCorrect('M');
    /**
     * 可存放的信息类型：
     *  N 数字
     *  A 数字+A-Z
     *  B 所有
     */
    qrcodeHandler.setQrcodeEncodeMode('B');
    //尺寸：取值范围 1~40
    qrcodeHandler.setQrcodeVersion(size);

    byte[] contentBytes = content.getBytes();
    boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);

    int imgSize = 67 + 12*(size-1);



    bufferedImage = new BufferedImage(imgSize,imgSize,BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics2D = bufferedImage.createGraphics();//创建一个画板
    graphics2D.setBackground(Color.white);
    graphics2D.clearRect(0,0,imgSize,imgSize); //初始化
    graphics2D.setColor(Color.black); //设置画板上图像的颜色（二维码的颜色）

    int pixoff = 2;

    for(int i=0;i<codeOut.length;i++) {
      for(int j=0;j<codeOut.length;j++) {
        if(codeOut[i][j]) {
          graphics2D.fillRect(j*3+pixoff,i*3+pixoff,3,3);
        }
      }
    }

    graphics2D.dispose();
    bufferedImage.flush();
    return bufferedImage;
  }
}
