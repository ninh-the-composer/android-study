package fpt.gstpro.architecturestudy.controller;

import java.util.List;

import fpt.gstpro.architecturestudy.model.Country;
import fpt.gstpro.architecturestudy.networking.CountriesApi;
import fpt.gstpro.architecturestudy.networking.CountriesService;
import fpt.gstpro.architecturestudy.view.CountriesActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CountriesController {
    private CountriesApi apiService;
    private final CountriesActivity view;

    public CountriesController(CountriesActivity view){
        this.view = view;
        apiService = CountriesService.getInstance().getService();
    }

    public void onFetchCountries(){
        apiService.getCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<Country>>() {
                    @Override
                    public void onSuccess(@NonNull List<Country> result) {
                        view.onSuccess(result);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.onError(e);
                    }
                });
    }
}
