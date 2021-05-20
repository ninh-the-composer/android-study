package fpt.gstpro.testswipetorefresh.presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import fpt.gstpro.testswipetorefresh.R;
import fpt.gstpro.testswipetorefresh.model.Cat;
import fpt.gstpro.testswipetorefresh.service.RetrofitClient;
import fpt.gstpro.testswipetorefresh.view.MainActivity;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Presenter implements IPresenter {

    private MainActivity view;
    public Presenter(MainActivity view){
        this.view = view;
    }
    @Override
    public void loadCat() {
        Single<List<Cat>> apiService = RetrofitClient.getInstance().getService().getCatSingle();

        apiService.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Cat>>() {
                    @Override
                    public void onSuccess(List<Cat> cats) {

                        ImageView imageView = view.findViewById(R.id.imageView);

                        Glide.with(view.getApplicationContext())
                                .load(cats.get(0).getUrl())
                                .error(R.drawable.ic_launcher_foreground)
                                .centerCrop()
                                .into(imageView);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(view.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.d("ERROR", e.getMessage());
                    }
                });
    }

}
