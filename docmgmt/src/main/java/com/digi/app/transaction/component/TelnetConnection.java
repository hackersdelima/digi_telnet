package com.digi.app.transaction.component;

import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

@Component
public class TelnetConnection {
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;


    public void getResponse(String command){
        String ip="";
        int port=0;
        boolean connectionStatus=startConnection(ip,port);
        if(connectionStatus) {
            String response = sendMessage(command);
            List<String> list = conversion(response);
            stopConnection();
        }

    }

    public List<String> conversion(String response) {

        //deleting unused part
        StringBuilder stringBuilder = new StringBuilder(response);
        int i = stringBuilder.indexOf("\"", 1);
        stringBuilder.delete(0, i);

        //splitting main data part into list
        String maindata = stringBuilder.toString();
        String d = maindata.replace("\",\"", "\"::\"");
        String[] splittedmaindatas = d.split("::");

        List<String> strings=null;
        //for first list value of splittedmaindatas
        for (String data : splittedmaindatas) {
            String pre = "\"";
            String post = "\"";
             strings = Arrays.asList(data.replaceAll("^.*?" + pre, "")
                    .split(post + ".*?(\"|$)"));

        }
        return strings;
    }

    public  boolean startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public  String sendMessage(String msg) {
        String resp = "";
        try {
            out.println(msg);
            resp = in.readLine();
            return resp;
        } catch (Exception e) {
            System.out.println(e);
        }
        return resp;
    }

    public  void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
