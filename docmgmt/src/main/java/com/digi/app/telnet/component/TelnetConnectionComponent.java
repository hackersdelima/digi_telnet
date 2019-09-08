package com.digi.app.telnet.component;

import com.digi.app.telnet.config.TelnetUser;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TelnetConnectionComponent {
    private static Socket clientSocket;
    private static PrintWriter out;
    private static BufferedReader in;

    private String ip = TelnetUser.ip;
    private int port = TelnetUser.port;

    public List<List<String>> telnetConnectionAndResponseList(String command) {
        boolean connectionStatus = startConnection(ip, port);
        if (connectionStatus) {
            String response = sendMessage(command);
            List<List<String>> responseList = conversion(response);
            stopConnection();
            return responseList;
        }
        return null;

    }

    public String telnetConnectionAndResponseString(String command) {
        boolean connectionStatus = startConnection(ip, port);
        if (connectionStatus) {
            String response = sendMessage(command);
            stopConnection();
            return response;
        }
        return null;

    }

    //TODO: need to work out at the for each loop section
    public List<List<String>> conversion(String response) {

        //deleting unused part
        StringBuilder stringBuilder = new StringBuilder(response);
        int firstQuotationIndex = stringBuilder.indexOf("\"", 1);
        stringBuilder.delete(0, firstQuotationIndex);

        //splitting main data part into list
        String dataAfterRemovingFirstPart = stringBuilder.toString(); //main data working fine
        String replacingCommaaByColons = dataAfterRemovingFirstPart.replace("\",\"", "\"::\"");
        String[] splittedmaindatas = replacingCommaaByColons.split("::");

        List<List<String>> responseList = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        //for first list value of splittedmaindatas

        //TODO: this loop is not working properly, need to create beautiful loop
        for (String data : splittedmaindatas) {
            String pre = "\"";
            String post = "\"";
            strings = Arrays.asList(data.replaceAll("^.*?" + pre, "")
                    .split(post + ".*?(\"|$)"));
            responseList.add(strings);
        }
        return responseList;
    }

    public boolean startConnection(String ip, int port) {
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

    public String sendMessage(String msg) {
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

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
