package fpt.gstpro.architecturestudy.networking;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesService {

    private static CountriesService instance = null;
    private CountriesApi myService;

    private CountriesService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(CountriesApi.SERVICE_ENDPOINT)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myService = retrofit.create(CountriesApi.class);
    }

    public static synchronized CountriesService getInstance() {
        if (instance == null) {
            instance = new CountriesService();
        }
        return instance;
    }

    public CountriesApi getService() {
        return myService;
    }
}
