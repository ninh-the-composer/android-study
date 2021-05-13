package fpt.gstpro.myapi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesMarvelRetrofitClient {

    private static HeroesMarvelRetrofitClient instance = null;
    private HeroesMarvelAPI myApi;

    private HeroesMarvelRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HeroesMarvelAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(HeroesMarvelAPI.class);
    }

    public static synchronized HeroesMarvelRetrofitClient getInstance() {
        if (instance == null) {
            instance = new HeroesMarvelRetrofitClient();
        }
        return instance;
    }

    public HeroesMarvelAPI getMyApi() {
        return myApi;
    }
}