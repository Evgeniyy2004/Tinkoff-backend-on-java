package edu.hw6;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import static java.net.http.HttpClient.newHttpClient;

public class HackerNews {
    public long[] hackerNewsTopStories() {
        try {
            var request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                .GET()
                .header("nothing", "special")
                .timeout(Duration.of(30, ChronoUnit.SECONDS))
                .build();
            var client = newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
            var str = client.body().split(",");
            long[] result = new long[str.length];
            for (int i = 0; i < str.length; i++) {
                result[i] = Long.parseLong(str[i]);
            }
            return result;

        } catch (URISyntaxException | IOException | InterruptedException e) {
            return new long[0];
        }

    }

    public String news(long id) {
        String myRegex = String.format("https://hacker-news.firebaseio.com/v0/item/%d.json",id);
        return ((JsonObject) new JsonParser().parse(myRegex)).get("title").toString();
    }
}
