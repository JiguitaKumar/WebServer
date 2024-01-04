package org.codeforall.ooptimus;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public static void main(String[] args) {

        try {
            //1º Create sockets to connect with the Client
            int port = 9000;
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();

            //2º Create Buffer to read request, in this exercise we just accept GETs
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String readRequest = reader.readLine();
            String requested = readRequest.split(" ")[1];

            ClientOptions clientOptions = new ClientOptions(requested);

            //4º Streams to read and send the files
            FileInputStream inputStream = new FileInputStream(clientOptions.fileRequested());
            OutputStream outputStream = clientSocket.getOutputStream();

            //6º Send the File requested
            outputStream.write(clientOptions.headerRequested().getBytes());
            byte[] buffer = new byte[(int) clientOptions.fileRequested().length()];
            inputStream.read(buffer); //Reads up to b.length bytes of data from this input stream into an array of bytes.
            outputStream.write(buffer); //Writes b.length bytes from the specified byte array to this file output stream.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
