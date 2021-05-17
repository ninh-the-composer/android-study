package fpt.gstpro.myapi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fpt.gstpro.myapi.model.Hero;
import fpt.gstpro.myapi.service.HeroAdapter;
import fpt.gstpro.myapi.service.HeroesMarvelRetrofitClient;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class HeroesMarvelActivity extends AppCompatActivity {

    private RecyclerView posts;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_marvel);
        this.posts = findViewById(R.id.rvMarvelHeroes);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.posts.setLayoutManager(mLayoutManager);

        Single<List<Hero>> apiService = HeroesMarvelRetrofitClient.getInstance().getMyApi().getHeroes();

        apiService.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Hero>>() {
                    @Override
                    public void onSuccess(@NonNull List<Hero> heroes) {
                        Log.d("GOOD", "Doan nay oke r nhe");
                        adapter = new HeroAdapter(heroes);
                        posts.setAdapter(adapter);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("ERROR", e.getMessage());

                    }
                });

//        Call<List<Hero>> call = HeroesMarvelRetrofitClient.getInstance().getMyApi().getHeroes();
//
//        call.enqueue(new Callback<List<Hero>>() {
//            @Override
//            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
//                List<Hero> heroList = response.body();
//
//                adapter = new HeroAdapter(heroList);
//                posts.setAdapter(adapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Hero>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//
//
//        });
    }
}