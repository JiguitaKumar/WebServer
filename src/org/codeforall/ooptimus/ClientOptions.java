package org.codeforall.ooptimus;

import java.io.File;

public class ClientOptions {

    private String request;

    public ClientOptions(String request){
        this.request = request;
    }


    //3º Files to be returned
    File image = new File("resources/image.JPG");
    File index = new File("resources/index.html");
    File error = new File("resources/404.html");

    //5º Headers to be sent along with the file
    String indexHeader = "HTTP/1.0 200 Document Follows\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: " + index.length() + " \r\n" +
            "\r\n";

    String imageHeader = "HTTP / 1.0 200 Document Follows\r\n" +
            "Content - Type:image /JPG \r\n" +
            "Content - Length: " + image.length() + " \r\n" +
            "\r\n";

    String errorHeader = "HTTP / 1.0 404 Not Found" +
            "Content - Type:text / html;" +
            "charset = UTF - 8\r\n" +
            "Content - Length: " + error.length() + " \r\n" +
            "\r\n";

    public File fileRequested(){
        switch(this.request){
            case "/image.jpg":
                return image;
            case "/index.html":
                return index;
            default:
                return error;
        }
    }

    public String headerRequested(){
        switch(this.request){
            case "/image.jpg":
                return imageHeader;
            case "/index.html":
                return indexHeader;
            default:
                return errorHeader;
        }
    }

}
