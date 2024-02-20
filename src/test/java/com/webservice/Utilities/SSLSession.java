package com.webservice.Utilities;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SSLSession {
    /**
     * Utility class for creating an "allow-all" certificates SSL context.
     */
    public static final class SSLUtils {

        private SSLUtils() {
        }

        /**
         * Create an SSL context that trusts each and every certificate (even those that are not signed).
         */
        public static void sslContext() {
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }};

            try {
                final SSLContext sslContext = SSLContext.getInstance("SSL");

                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

                HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());

                final HostnameVerifier allHostsValid = (hostname, session) -> true;

                // set the  allTrusting verifier
                HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            } catch (final NoSuchAlgorithmException | KeyManagementException exception) {
                throw new RuntimeException("Failed to create a SSL socket factory", exception);
            }
        }
    }

}
