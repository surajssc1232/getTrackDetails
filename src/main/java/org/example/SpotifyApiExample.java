package org.example;

import okhttp3.*;
import org.json.JSONObject;

import java.util.Scanner;

public class SpotifyApiExample {
    public static void main(String[] args) throws Exception {
        Scanner scan=new Scanner(System.in);
        String accessToken = SpotifyAuth.getAccessToken(); // Get the access token
        OkHttpClient client = new OkHttpClient();

        // Example: Fetch data for a specific track
        System.out.print("Enter the track ID: ");
        String trackId = scan.next(); // Replace with the actual track ID
        String url = "https://api.spotify.com/v1/tracks/" + trackId;

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + accessToken) // Add the access token to headers
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                // Parse and print the response
                JSONObject trackData = new JSONObject(response.body().string());
                System.out.println("Track Name: " + trackData.getString("name"));
                System.out.println("Artist: " + trackData.getJSONArray("artists").getJSONObject(0).getString("name"));
                System.out.println("Album: " + trackData.getJSONObject("album").getString("name"));
                System.out.println("Release Date: " + trackData.getJSONObject("album").getString("release_date"));
                System.out.println("Popularity: " + trackData.getInt("popularity"));
            } else {
                System.out.println("Request failed: " + response.message());
            }
        }
    }
}
