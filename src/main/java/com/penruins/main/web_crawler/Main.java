package com.penruins.main.web_crawler;

import lombok.SneakyThrows;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 网络爬虫 web crawler 是一种按照一定的规则，自动地抓取万维网信息的程序
 * 或者脚本
 *
 *
 * httpclient
 *
 * 网络爬虫就是用程序帮助我们访问网络上的资源，我们一直以来都是使用HTTP协议访问互联网
 * 的网页，网络爬虫需要编写程序，在这里使用同样的HTTp协议访问网页
 * 这里我们使用Java的HTTP协议客户端HttpClient这个技术，来实现抓取网页数据
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        //1. 打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2. 输入网址
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");
        //3. 按回车，发起请求，返回响应
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        //4. 解析响应，获取数据
        //判断状态码是否是200
        if(httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = httpResponse.getEntity();
            String content = EntityUtils.toString(httpEntity,"utf8");
            System.out.println(content);
        }
    }
}
