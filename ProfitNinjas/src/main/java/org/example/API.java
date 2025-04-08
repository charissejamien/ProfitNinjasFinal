package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

public class API {

    private static final OkHttpClient client = new OkHttpClient();

    private static long lastRequestTime = 0;
    private static final long RATE_LIMIT_RESET_TIME = 60000;

    public static class Coin {
        String name;
        String symbol;
        double price;
        double marketCap;
        double volume;
        double high;
        double low;
        double priceChange;
        float priceChangePercentage;
        String imageUrl;

        public Coin(String name, String symbol, double price, double marketCap, double volume, double high, double low,
                    double priceChange, float priceChangePercentage, String imageUrl) {
            this.name = name;
            this.symbol = symbol;
            this.price = price;
            this.marketCap = marketCap;
            this.volume = volume;
            this.high = high;
            this.low = low;
            this.priceChange = priceChange;
            this.priceChangePercentage = priceChangePercentage;
            this.imageUrl = imageUrl;
        }
    }

    // Fetch coins from the CoinGecko API
    public static List<Coin> getCoins() {

        long currentTime = System.currentTimeMillis();
        if (lastRequestTime > 0 && (currentTime - lastRequestTime) < RATE_LIMIT_RESET_TIME) {
            long sleepTime = RATE_LIMIT_RESET_TIME - (currentTime - lastRequestTime);
            System.out.println("Rate limit hit. Sleeping for " + sleepTime / 1000 + " seconds...");
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        List<Coin> coins = new ArrayList<>();

        // API request
        Request request = new Request.Builder()
                .url("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=19&page=1")
                .get()
                .addHeader("accept", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                JsonArray coinsArray = JsonParser.parseString(response.body().string()).getAsJsonArray();
                for (JsonElement coinElement : coinsArray) {
                    JsonObject coin = coinElement.getAsJsonObject();
                    coins.add(parseCoin(coin));
                }
                System.out.println("Market Data Updated");
            } else {
                System.out.println("Error: " + response.code() + " " + response.message());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coins;
    }

    // Parse the JSON response for a coin
    private static Coin parseCoin(JsonObject coin) {
        String name = coin.get("name").getAsString();
        String symbol = coin.get("symbol").getAsString().toUpperCase();
        double price = coin.get("current_price").getAsDouble();
        double marketCap = coin.get("market_cap").getAsDouble();
        double volume = coin.get("total_volume").getAsDouble();
        double high = coin.get("high_24h").getAsDouble();
        double low = coin.get("low_24h").getAsDouble();
        double priceChange = coin.get("price_change_24h").getAsDouble();
        float priceChangePercentage = coin.get("price_change_percentage_24h").getAsFloat();
        String imageUrl = coin.get("image").getAsString();
        return new Coin(name, symbol, price, marketCap, volume, high, low, priceChange, priceChangePercentage, imageUrl);
    }
}