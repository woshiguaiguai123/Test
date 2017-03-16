package com.googl.xcdq.mytest2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端：
 1. 创建服务端的Socket
 2. 接收连接到此服务端的客户端Socket
 3. 打开连接的客户端Socket输入/输出流。
 4. 对Socket进行读/写操作。
 5. 关闭连接到此服务端的客户端Socket。
 *
 */

public class Socketservice {

    public static void main(String[] arges) throws IOException {
        ServerSocket serverSocket=new ServerSocket(30000);
        while(true){
            Socket socket=serverSocket.accept();
            System.out.println("connect succes");
            new Thread(new ServerThread(socket)).start();
        }
    }
}
