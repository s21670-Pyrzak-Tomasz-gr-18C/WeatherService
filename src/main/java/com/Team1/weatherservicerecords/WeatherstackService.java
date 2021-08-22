package com.Team1.weatherservicerecords;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherstackService {
    private String apkey = "66e7f02c0783882ce944bbbc847ffe7d";
    private final String BASE_URL = "http://api.weatherstack.com/current?access_key=";
    private String url;

    public void createBaseUrl(String cityName) {
        url = BASE_URL+apkey+"&query="+cityName ;
    }

    public Response getResponseFromWeatherstack() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        Response response = call.execute();
        return response;
    }
}
