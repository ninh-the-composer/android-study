package fpt.gstpro.testviewpager.service;

import java.util.List;

import fpt.gstpro.testviewpager.model.Photo;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    String SERVICE_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    @GET("photos")
    Single<List<Photo>> getPhotos();
}
