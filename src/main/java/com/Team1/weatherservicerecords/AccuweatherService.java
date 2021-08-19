package com.Team1.weatherservicerecords;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherService {
    private String apkey = "iLMHejPpxQb8aAHiKEisjROm5rjq7uNu";
    private final String BASE_URL = "http://dataservice.accuweather.com/locations/v1/search?q=";
    private String Url;

    public String createBaseUrl( String cityName) {
        Url=BASE_URL + cityName+"&apkey="+apkey;
        return Url;
    }

    public Response getResponseFromAcuweather() throws IOException {
        Request request = new Request.Builder()
                .url(Url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Call call = client.newCall(request);
        Response response = call.execute();
        return  response;
    }





}
