package fpt.gstpro.myapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.gstpro.myapi.model.Post;
import fpt.gstpro.myapi.service.JSONPlaceholderRetrofitClient;
import fpt.gstpro.myapi.service.PostAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JSONPlaceholderPostsActivity extends AppCompatActivity {

    private RecyclerView posts;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonplaceholder_posts);

        this.posts = findViewById(R.id.rvPost);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.posts.setLayoutManager(mLayoutManager);

        Call<List<Post>> call = JSONPlaceholderRetrofitClient.getInstance().getMyApi().getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> postList = response.body();

                adapter = new PostAdapter(postList);
                posts.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}