package com.penruins.main.socket;


import lombok.SneakyThrows;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

/**
 * 要在网络上实现邮件功能，必须要有专门的邮件服务器
 * 这些邮件服务器类似于现实生活着的邮局，它主要负责接收用户投递过来的邮件，并把邮件投递到邮件接受者的电子邮箱中。
 * SMTP服务器地址，一般是smtp.xxx.com
 *      smtp.163.com
 *      smtp.qq.com
 *
 * 我们通常把处理永和smtp请求的服务器称之为smtp服务器
 *
 *
 */
public class MailSender {
    public static final char[] chars = {'1','2','3','4','5','6','7','8','9','0'};
    public static Random random = new Random();
    public static String getVerificatioinCode() {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=5;i++) {
            sb.append(chars[random.nextInt(chars.length)]);
        }
        return sb.toString();
    }

    public static boolean sendMail(String subject, String to, String content) {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol","SMTP");
        properties.put("mail.smtp.host","smtp.qq.com");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.username","1007656785@qq.com");
        properties.put("mail.password","Lx.tdcq.comDEU21");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("1007656785@qq.com","Lx.tdcq.comDEU21");
            }
        };

        Session session = Session.getInstance(properties,auth);
        MimeMessage message = new MimeMessage(session);
        try {

            message.setFrom(new InternetAddress("1007656785@qq.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message);
        } catch(Exception e) {
            System.err.println("邮件发送失败的原因是：" + e.getMessage());
            System.err.println("具体的错误原因");
            e.printStackTrace(System.err);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = getVerificatioinCode();
        sendMail("验证码","lx_tdcq_king@icloud.com"," 您的验证码是： " + s);
        System.out.println("邮件发送完毕   " + s);
    }
}
