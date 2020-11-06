package com.penruins.QRCode.zxing;

import com.alibaba.fastjson.JSON;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class ZxingUtil {

  public static final int WIDTH = 300;
  public static final int HEIGHT = 300;
  public static final String FORMAT = "png";
  public static final String CHARTSET = "utf-8";

  public static void createQRcode(String filePath) throws WriterException, IOException {
    System.setProperty("java.specification.version", "1.9"); //如果用的jdk是1.9，需要配置下面这一行
    FiveElements fiveElements = new FiveElements();
    fiveElements.setName("zhao");
    fiveElements.setGender("M");
    fiveElements.setIdType("I");
    fiveElements.setIdno("370983");
    fiveElements.setMobile("1805310");
    String contents = JSON.toJSONString(fiveElements);
    HashMap<EncodeHintType, Object> hints = new HashMap<>();
    hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
    hints.put(EncodeHintType.MARGIN, 2);

    BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
    Path file = new File(filePath).toPath();
    MatrixToImageWriter.writeToPath(bitMatrix, FORMAT, file);
    System.out.println("创建二维码完成");
  }


  public static Result getQRresult(String filePath) {
    System.setProperty("java.specification.version", "1.9"); //如果用的jdk是1.9，需要配置下面这一行
    Result result = null;
    try {
      File file = new File(filePath);

      BufferedImage bufferedImage = ImageIO.read(file);
      BinaryBitmap bitmap = new BinaryBitmap(
              new HybridBinarizer(new BufferedImageLuminanceSource(bufferedImage)));

      HashMap hints = new HashMap<>();
      hints.put(EncodeHintType.CHARACTER_SET, CHARTSET);
      result = new MultiFormatReader().decode(bitmap, hints);
    } catch (NotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }
}
