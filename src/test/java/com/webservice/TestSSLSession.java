package com.webservice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import com.webservice.Utilities.SSLSession;

public class TestSSLSession {
    public static void main(String[] args) {
        // Configurar el contexto SSL "allow-all"
        SSLSession.SSLUtils.sslContext();

        try {
            // Realiza una conexión HTTPS a una URL (reemplaza con la URL deseada)
            URL url = new URL("https://ecommerce-playground.lambdatest.io");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Realiza la solicitud
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Aquí puedes manejar la respuesta según tus necesidades
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
