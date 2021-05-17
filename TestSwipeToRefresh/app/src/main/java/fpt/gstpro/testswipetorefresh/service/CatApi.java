package fpt.gstpro.testswipetorefresh.service;

import java.util.List;

import fpt.gstpro.testswipetorefresh.model.Cat;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface CatApi {
    String SERVICE_ENDPOINT = "https://api.thecatapi.com";

    @GET("/v1/images/search")
    Single<List<Cat>> getCat();
}
