package com.penruins.web_crawler.v_1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 爬取豆瓣电影的影评
 */
public class Test001 {
  public static void main(String[] args) throws Exception{
    String url = "https://movie.douban.com/subject/26861685/reviews?start=0";


    StringBuffer sb = new StringBuffer();

    URL url1 = new URL(url);
    URLConnection uc = url1.openConnection();
    uc.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
    InputStreamReader isr = new InputStreamReader(uc.getInputStream(),"UTF-8");
    BufferedReader br = new BufferedReader(isr);

    String temp = null;
    while((temp=br.readLine()) != null) {
      sb.append(temp + "\n");
    }

    br.close();
    isr.close();


    String html = sb.toString();
    Document document = Jsoup.parse(html);
    Element element = document.getElementById("content");
    Elements elements = document.getElementsByClass("main review-item");
    for(Element el : elements) {
      String name = el.getElementsByClass("name").text();
      String comment = el.getElementsByClass("short-content").text();
      System.out.println(name + "{" + comment + "}");
    }
  }
}
