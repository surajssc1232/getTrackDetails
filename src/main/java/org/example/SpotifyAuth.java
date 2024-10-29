package org.example;

import okhttp3.*;
import java.io.IOException;
import java.util.Base64;
import org.json.JSONObject;

public class SpotifyAuth {
    private static final String CLIENT_ID = "cf215981c8e548e2b2a70b1e3e244001"; // Replace with your Client ID
    private static final String CLIENT_SECRET = "559466c34a6343beb827e9d94e7bedc5"; // Replace with your Client Secret
    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";

    public static String getAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Correctly encode Client ID and Secret in Base64
        String credentials = CLIENT_ID + ":" + CLIENT_SECRET;
        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());

        // Build the request
        RequestBody body = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();

        Request request = new Request.Builder()
                .url(TOKEN_URL)
                .header("Authorization", basicAuth)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                // Parse JSON response to extract access token
                String responseBody = response.body().string();
                JSONObject json = new JSONObject(responseBody);
                return json.getString("access_token");
            } else {
                System.out.println("Error: " + response.code() + " - " + response.message());
                System.out.println("Body: " + response.body().string());
                throw new IOException("Failed to get access token");
            }
        }
    }
}
