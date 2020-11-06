package com.penruins.xml;


import lombok.Getter;
import lombok.Setter;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Getter
@Setter
public class AjavaBeanToXML {
    private Long id;
    private String siteName;
    private String url;
    private String detail;

    public static void main(String[] args) {
        AjavaBeanToXML bean = new AjavaBeanToXML();
        bean.setId(new Long(1));
        bean.setSiteName("AJAVA独立社区");
        bean.setUrl("http://ajava.org");
        bean.setDetail("AJava是一个独立的Java社区，致力于提供用户交流平台和优质原创教程、文档、书籍");

        try {
            XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("AjavaBean.xml")));
            encoder.writeObject(bean);
            encoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
