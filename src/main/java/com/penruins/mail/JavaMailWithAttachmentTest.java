package com.penruins.mail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class JavaMailWithAttachmentTest {
  public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
    Properties properties = new Properties();
    properties.setProperty("mail.transport.protocol","smtp");//使用协议：smtp
    properties.setProperty("mail.smtp.host","smtp.qq.com"); //协议地址
    properties.setProperty("mail.smtp.port","465");//协议端口
    properties.setProperty("mail.smtp.auth","true");//需要授权
    //QQ：SSL安全认证
    properties.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
    properties.setProperty("mail.smtp.socketFactory.fallback","false");
    properties.setProperty("mail.smtp.socketFactory.port","465");
    Session session = Session.getInstance(properties);
    session.setDebug(true);

    //创建邮件
    MimeMessage message = createMimeMessage(session,"1007656785@qq.com","lx_tdcq_king@icloud.com","lx_tdcq_king@icloud.com","lx_tdcq_king@icloud.com");
    Transport transport = session.getTransport();//建立连接对象
    transport.connect("1007656785@qq.com","wlikzaqckljnbfbi");//打开连接,其中密码以"授权码"的形式体现
    transport.sendMessage(message,message.getAllRecipients());
    transport.close();
  }

  /**
   * MIME Multipurpose Internet Mail Extensions 多用途互联网邮件扩展类型
   */
  public static MimeMessage createMimeMessage(Session session,String send,String receive,String cReceive,String bReceive ) throws MessagingException, UnsupportedEncodingException {
    MimeMessage message = new MimeMessage(session);
    Address address = new InternetAddress(send,"发件人的名字","UTF-8");
    message.setFrom(address);
    message.setSubject("这是标题","UTF-8");


    //创建图片节点
    MimeBodyPart imagePart = new MimeBodyPart();
    DataHandler imageDataHandler = new DataHandler(new FileDataSource("src/main/resources/zxingQRCode.png"));
    imagePart.setDataHandler(imageDataHandler);
    imagePart.setContentID("myImage");

    //创建文本节点：目的是为了加载图片节点
    MimeBodyPart textPart = new MimeBodyPart();
    textPart.setContent("正文内容。。Hello... image:<img src='cid:myImage'/>","text/html;charset=utf-8");


    //将文本节点，图片节点 组装
    MimeMultipart mm_text_image = new MimeMultipart();
    mm_text_image.addBodyPart(imagePart);
    mm_text_image.addBodyPart(textPart);
    mm_text_image.setSubType("related");//关联关系

    //注意：正文中 只能出现普通节点 不能出现复合节点MimeMultipart
    MimeBodyPart text_image_bodyPart = new MimeBodyPart();
    text_image_bodyPart.setContent(mm_text_image);

    //附件
    MimeBodyPart attachment = new MimeBodyPart();
    DataHandler attachmentHandler = new DataHandler(new FileDataSource("src/main/resources/wallhaven-oxkjgm.jpg"));
    attachment.setDataHandler(attachmentHandler);
    attachment.setFileName(MimeUtility.encodeText(attachmentHandler.getName()));//给附件设置文件名

    //将「文本+图片」节点与「附件」设置成一个新的复合节点
    MimeMultipart mm = new MimeMultipart();
    mm.addBodyPart(text_image_bodyPart);
    mm.addBodyPart(attachment);
    mm.setSubType("mixed");


    message.setContent(mm,"text/html;charset=utf-8");




    //收件人类型：普通收件人 TO、抄送 CC、密送 BCC
    message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receive,"收件人A","UTF-8"));
    message.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress(receive,"抄送人A","UTF-8"));
    message.setRecipient(MimeMessage.RecipientType.BCC,new InternetAddress(receive,"密送人A","UTF-8"));
    message.setSentDate(new Date());
    message.saveChanges();
    return message;
  }
}
