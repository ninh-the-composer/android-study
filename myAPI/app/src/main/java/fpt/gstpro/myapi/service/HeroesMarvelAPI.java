package fpt.gstpro.myapi.service;

import java.util.List;

import fpt.gstpro.myapi.model.Hero;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface HeroesMarvelAPI {
    public String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Single<List<Hero>> getHeroes();

//    @GET("marvel")
//    Call<List<Hero>> getHeroes();
}
