package engine;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import models.ParamRequest;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class NetworkUtils {

    public void startLocalRESTAPI() throws IOException {
        DBUtils dbUtils = new DBUtils();
        int serverPort = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);
        server.createContext("/api/hello", ((HttpExchange exchange) -> {

            if ("POST".equals(exchange.getRequestMethod())) {

                System.out.println(exchange.getRequestURI().toString());
                System.out.println(exchange.getRequestMethod());

                Scanner scanner = new Scanner(exchange.getRequestBody()).useDelimiter("\\A");
                String requestString = scanner.hasNext() ? scanner.next() : "";

                ObjectMapper objectMapper = new ObjectMapper();
                ParamRequest paramRequest = objectMapper.readValue(requestString, ParamRequest.class);
                System.out.println("------------>");
                System.out.println(paramRequest.toString());
                System.out.println("------------>");

                if (paramRequest.getRegistration()) {
                    dbUtils.createUserMock(paramRequest.getPhoneNumber(), paramRequest.getClientID(), paramRequest.getLastName());
                } else {
                    dbUtils.createVoidUser(paramRequest.getPhoneNumber());
                }

                exchange.sendResponseHeaders(200, "OK".length());
                OutputStream output = exchange.getResponseBody();
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
            exchange.close();
        }));
        server.setExecutor(null);
        server.start();
    }

}
