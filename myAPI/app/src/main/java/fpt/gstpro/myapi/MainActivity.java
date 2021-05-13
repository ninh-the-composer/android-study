package fpt.gstpro.myapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import fpt.gstpro.myapi.model.Post;
import fpt.gstpro.myapi.service.PostAdapter;
import fpt.gstpro.myapi.service.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView posts;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.posts = findViewById(R.id.rvPost);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.posts.setLayoutManager(mLayoutManager);

        Call<List<Post>> call = RetrofitClient.getInstance().getMyApi().getPosts();

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