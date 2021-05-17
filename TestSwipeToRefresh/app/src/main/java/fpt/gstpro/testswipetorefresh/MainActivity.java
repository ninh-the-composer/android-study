package fpt.gstpro.testswipetorefresh;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;

import java.util.List;

import fpt.gstpro.testswipetorefresh.model.Cat;
import fpt.gstpro.testswipetorefresh.service.RetrofitClient;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadCat();

        SwipeRefreshLayout mSwpLayout = findViewById(R.id.swipeLayout);
        mSwpLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadCat();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwpLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
    }

    private void loadCat() {
        Single<List<Cat>> apiService = RetrofitClient.getInstance().getService().getCat();

        apiService.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Cat>>() {
                    @Override
                    public void onSuccess(List<Cat> cats) {
                        Cat cat = cats.get(0);
                        ImageView imageView = findViewById(R.id.imageView);
                        Glide.with(getApplicationContext())
                                .load(cat.getUrl())
                                .error(R.drawable.ic_launcher_foreground)
                                .centerCrop()
                                .into(imageView);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("ERROR", e.getMessage());
                    }
                });
    }

}