package com.penruins.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * https://blog.csdn.net/yanghua_kobe/article/details/7296156
 *
 * Http是个大协议，完整功能的HTTP服务器必须响应资源请求，将URL转换为本地系统的资源名。响应各种形式的HTTP请求（GET、POST等）处理不存在的文件请求，返回各种形式的状态码，解析MIME类型等
 * 但许多特定功能的HTTP服务器并不需要所有这些功能。
 *
 * 定制服务器不只是用于小网站。大流量的网站如Yahoo，也使用定制服务器，因为与一般用途的服务器相比，只做一件轻视的服务器通常要快得多。针对某项任务来优化特殊用途的服务器很容易
 * 其结果往往比需要响应多种请求的一般用途服务器高效得多。例如，对于重复用于多页面或大流量页面中的图标和图片，用一个单独的服务器处理会更好（并且还可以避免在请求时携带不必要的
 * Cookie，因此可以减少请求/响应数据，从而减少下载带宽，提升速度）；这个服务器在启动时把所有图片文件读入内存，从RAM中直接提供这些文件，而不是每次请求都从磁盘上读取。此外，
 * 如果你不想在包含这些图片的页面请求之外单独记录这些图片，这个单独服务器则会避免在日志记录上浪费时间
 */


/**
 * 该服务器的功能：无论接受何种请求，都始终发送同一个文件。
 *
 *
 */
public class SingleFileHTTPServer extends Thread{
    private byte[] content;
    private byte[] header;
    private int port = 80;

    private SingleFileHTTPServer(String data, String encoding, String MIMEType, int port) throws UnsupportedEncodingException {
        this(data.getBytes(encoding),encoding,MIMEType,port);
    }

    /**
     * 这个是对外的构造方法
     * 它和上面私有的构造方法的区别在于第一个参数不同，程序要求调用者提供的参数是字节数组
     * @param data 数据
     * @param encoding 编码方式
     * @param MIMEType
     * @param port 端口号
     * @throws UnsupportedEncodingException
     */
    public SingleFileHTTPServer(byte[] data, String encoding, String MIMEType, int port) throws UnsupportedEncodingException {
        this.content = data;
        this.port = port;
        String header = "HTTP/1.0 200 OK\r\n" +
                "Server: OneFile 1.0\r\n" +
                "Content-length: " + this.content.length + "\r\n" +
                "Content-type: " + MIMEType + "\r\n\r\n";
        this.header=header.getBytes("ASCII");
    }

    /**
     * SingleFileHTTPServer类本身是Thread的子类。它的run()方法处理入站连接
     * 此服务器可能只是提供小文件，而且只支持低吞吐量的web网站。
     */
    public void run() {
        Socket connection = null;
        try {
            ServerSocket server = new ServerSocket(this.port); //本地的服务器
            System.out.println("Accepting connection on port " + server.getLocalPort());
            System.out.println("Data to be sent: ");
            System.out.println(this.content);

            while(true) {
                connection = server.accept();
                OutputStream out = new BufferedOutputStream(connection.getOutputStream()); //获取socket的输出流
                InputStream in = new BufferedInputStream(connection.getInputStream()); //获取socket的输入流
                StringBuffer request = new StringBuffer();
                while(true) {
                    int c = in.read();
                    if(c=='\r' || c=='\n' || c==-1) {
                        break;
                    }
                    request.append((char) c);
                }
                /**
                 * 它查看第一行是否包含字符串HTTP。如果包含此字符串，服务器就假定客户端理解HTTP/1.0或以后的版本，因此为该文件发送一个MIME首部
                 * 如果客户端请求不包含字符串HTTP，服务器就忽略首部，直接发送数据
                 */
                if(request.toString().indexOf("HTTP/")!=-1) {
                    out.write(this.header);
                }
                out.write(this.content);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 测试结果说明，该单文件服务器什么文件都是能分享的
     * 我测试了html文件和图片
     * 图片的传输时有时无
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String filename = "src/main/resources/element_of_persuasion.html";
//        String filename = "src/main/resources/wallhaven-oxkjgm.jpg";
        int port = 22222;
        String encoding = "ASCII";


        String contentType = "text/plain";
        if(filename.endsWith(".html") || filename.endsWith(".htm")) {
            contentType = "text/html";
        }
        InputStream in = new FileInputStream(filename);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int b;
        while((b=in.read()) !=-1) {
            out.write(b);
        }
        byte[] data = out.toByteArray();


        if(port<1 || port>65535) {
            port=80;
        }
        Thread t = new SingleFileHTTPServer(data,encoding,contentType,port);
        t.start();
    }
}
