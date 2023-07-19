package org.example.threadpooling;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.imageprocessing.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ThroughputHttpServer {
    private final static InputStream is = Main.class.getClassLoader().getResourceAsStream("war_and_peace.txt");
    private final static int NUMBER_OF_THREADS = 2000;

    public static void main(String... args) throws IOException {
        String result = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
        startServer(result);
    }

    public static void startServer(String text) throws IOException {
        var server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new WordCountHandler(text));
        var executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();
    }


    private static class WordCountHandler implements HttpHandler {
        private String text;

        public WordCountHandler(String text) {
            this.text = text;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            var query = exchange.getRequestURI().getQuery();
            String[] keyValue = query.split("=");
            var action = keyValue[0];
            var word = keyValue[1];
            if (!action.equals("word")) {
                exchange.sendResponseHeaders(400, 0);
                return;
            }
            var count = countWord(word);

            byte[] response = Long.toString(count).getBytes();
            exchange.sendResponseHeaders(200, response.length);
            var outputStream = exchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();
        }

        private long countWord(String word) {
            long count = 0;
            int index = 0;
            while (index >= 0) {
                index = text.indexOf(word, index);
                if(index >= 0){
                    count++;
                    index++;
                }
            }
            return count;
        }
    }

}
