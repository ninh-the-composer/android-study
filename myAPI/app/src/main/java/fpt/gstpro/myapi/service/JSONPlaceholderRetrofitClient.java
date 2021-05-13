package fpt.gstpro.myapi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JSONPlaceholderRetrofitClient {

    private static JSONPlaceholderRetrofitClient instance = null;
    private PlaceholderAPI myApi;

    private JSONPlaceholderRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(PlaceholderAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(PlaceholderAPI.class);
    }

    public static synchronized JSONPlaceholderRetrofitClient getInstance() {
        if (instance == null) {
            instance = new JSONPlaceholderRetrofitClient();
        }
        return instance;
    }

    public PlaceholderAPI getMyApi() {
        return myApi;
    }
}