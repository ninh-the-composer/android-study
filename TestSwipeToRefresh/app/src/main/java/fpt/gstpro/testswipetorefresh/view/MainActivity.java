package fpt.gstpro.testswipetorefresh.view;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import fpt.gstpro.testswipetorefresh.R;
import fpt.gstpro.testswipetorefresh.model.Cat;
import fpt.gstpro.testswipetorefresh.presenter.IPresenter;
import fpt.gstpro.testswipetorefresh.presenter.Presenter;
import fpt.gstpro.testswipetorefresh.service.RetrofitClient;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = new Presenter(this);
        loadCat();
        addSwipeToRefresh();
    }

    @Override
    public void loadCat() {
        Single<List<Cat>> apiService = RetrofitClient.getInstance().getService().getCatSingle();

        apiService.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Cat>>() {
                    @Override
                    public void onSuccess(List<Cat> cats) {
                        ImageView imageView = findViewById(R.id.imageView);
                        mPresenter.loadCat(cats.get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("ERROR", e.getMessage());
                    }
                });
    }

    @Override
    public void addSwipeToRefresh() {
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

}