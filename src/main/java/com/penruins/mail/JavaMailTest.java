package com.penruins.mail;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class JavaMailTest {
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
    message.setContent("正文内容。。Hello...","text/html;charset=utf-8");
    //收件人类型：普通收件人 TO、抄送 CC、密送 BCC
    message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(receive,"收件人A","UTF-8"));
    message.setRecipient(MimeMessage.RecipientType.CC,new InternetAddress(receive,"抄送人A","UTF-8"));
    message.setRecipient(MimeMessage.RecipientType.BCC,new InternetAddress(receive,"密送人A","UTF-8"));
    message.setSentDate(new Date());
    message.saveChanges();
    return message;
  }
}
