package com.Team1.weatherservicerecords;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OpenweatherService {
    private String apkey ="e4ca4fd5315cdd1fcee3ff9acdca07b9";
    private final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private String url;

    public void createBaseUrl(String cityName) {
        url = BASE_URL+cityName+"&appid="+apkey ;
      // url = "https://api.openweathermap.org/data/2.5/weather?q=Warszawa&appid=e4ca4fd5315cdd1fcee3ff9acdca07b9";
        System.out.println(url);
    }

    public Response getResponseFromOpenweather() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        Response response = call.execute();
        return response;
    }
}

