package com.googl.xcdq.mytest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by xcdq on 2017/3/15.
 */

class ServerThread implements Runnable {
    private Socket mSocket=null;
    private BufferedReader mBufferedReader = null;

    public ServerThread(Socket socket) throws IOException {
        mSocket = socket;
        mBufferedReader=new BufferedReader(new InputStreamReader(mSocket.getInputStream(),"utf-8"));
    }

    @Override
    public void run() {

    }
}
