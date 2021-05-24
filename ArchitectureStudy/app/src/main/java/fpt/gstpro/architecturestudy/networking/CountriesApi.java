package fpt.gstpro.architecturestudy.networking;

import java.util.List;

import fpt.gstpro.architecturestudy.model.Country;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface CountriesApi {

    String SERVICE_ENDPOINT = "https://restcountries.eu/rest/v2/";

    @GET("all")
    Single<List<Country>> getCountries();
}
