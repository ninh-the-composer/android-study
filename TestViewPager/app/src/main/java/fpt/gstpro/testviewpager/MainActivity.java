package fpt.gstpro.testviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import fpt.gstpro.testviewpager.model.Photo;
import fpt.gstpro.testviewpager.service.RetrofitClient;
import fpt.gstpro.testviewpager.ui.PagerAdapter;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadListPhoto();
    }
    private void loadViewPager(List<Photo> photoList){

        viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(this, photoList);
        viewPager.setAdapter(pagerAdapter);
    }

    private void loadListPhoto() {
        Single<List<Photo>> observable = RetrofitClient.getInstance().getService().getPhotos();

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Photo>>() {
                    @Override
                    public void onSuccess(List<Photo> photos) {
                        Log.d("HEREEEEEEEEEEE", photos.size() + "");
                        // Hard code
                        // Reason: Don't know how to get iteration each Object in JSON array
                        loadViewPager(photos.subList(0,4));
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.d("ERROR", e.getMessage());
                    }
                });
    }
}