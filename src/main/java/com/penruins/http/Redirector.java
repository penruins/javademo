package com.penruins.http;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/**
 * 重定向服务器
 * 实现的功能--将用户从一个Web网站重定向到另一个站点。
 */
public class Redirector implements Runnable {

    private int port;
    private String newSite;

    public Redirector(String site, int port){
        this.port=port;
        this.newSite=site;
    }

    @Override
    public void run() {
        try {
            ServerSocket server=new ServerSocket(port);
            System.out.println("Redirecting connection on port" +server.getLocalPort()+" to "+newSite);

            while (true) {
                try {
                    Socket socket=server.accept();
                    Thread thread=new RedirectThread(socket);
                    thread.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (BindException e) {
            System.err.println("Could not start server. Port Occupied");
        }catch (IOException e) {
            System.err.println(e);
        }

    }

    class RedirectThread extends Thread {

        private Socket connection;

        RedirectThread(Socket s) {
            this.connection=s;
        }

        public void run() {
            try {
                /**
                 * 从socket获取到的输入输出流都是字节流
                 */
                Writer out=new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(),"ASCII"));
                Reader in=new InputStreamReader(new BufferedInputStream(connection.getInputStream()));

                //获取消息头
                StringBuffer request=new StringBuffer(80); //消息头为80个字节
                while (true) {
                    int c=in.read();
                    if (c=='\r'||c=='\n'||c==-1) {
                        break;
                    }
                    request.append((char)c);
                }

                String get=request.toString();
                int firstSpace=get.indexOf(' ');
                int secondSpace=get.indexOf(' ', firstSpace+1);
                String theFile=get.substring(firstSpace+1, secondSpace);

                if (get.indexOf("HTTP")!=-1) {
                    out.write("HTTP/1.0 302 FOUND\r\n");
                    Date now=new Date();
                    out.write("Date: "+now+"\r\n");
                    out.write("Server: Redirector 1.0\r\n");
                    out.write("Location: "+newSite+theFile+"\r\n");
                    out.write("Content-Type: text/html\r\n\r\n");
                    out.flush();
                }

                //并非所有的浏览器都支持重定向，
                //所以我们需要生成一个适用于所有浏览器的HTML文件，来描述这一行为
                out.write("<HTML><HEAD><TITLE>Document moved</TITLE></HEAD>\r\n");
                out.write("<BODY><H1>Document moved</H1></BODY>\r\n");
                out.write("The document "+theFile
                        +" has moved to \r\n<A HREF=\""+newSite+theFile+"\">"
                        +newSite+theFile
                        +"</A>.\r\n Please update your bookmarks");
                out.write("</BODY></HTML>\r\n");
                out.flush();
            } catch (IOException e) {
            }finally{
                try {
                    if (connection!=null) {
                        connection.close();
                    }
                } catch (IOException e2) {

                }
            }
        }

    }

    public static void main(String[] args) {
        int thePort = 22222;
        String theSite = "http://www.sspai.com";
        Thread t=new Thread(new Redirector(theSite, thePort));
        t.start();
    }

}