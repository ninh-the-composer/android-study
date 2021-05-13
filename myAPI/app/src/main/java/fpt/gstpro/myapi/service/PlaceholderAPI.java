package fpt.gstpro.myapi.service;



import java.util.List;

import fpt.gstpro.myapi.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderAPI {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<List<Post>> getPosts();
}
