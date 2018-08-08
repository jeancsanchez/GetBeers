package com.example.data.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.example.data.BeersDataSource;
import com.example.domain.models.Beer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Concrete implementation of a {@link BeersDataSource} as a rest service.
 *
 * @author Jean Carlos
 * @since 5/10/17
 */

@Singleton
public class RemoteBeers implements BeersDataSource {

    private Context context;
    private RetrofitService mRetrofitService;

    @Inject
    RemoteBeers(@NonNull Context context) {
        mRetrofitService = RetrofitService.Creator.newRetrofitService();
    }

    @Override
    public void fetchBeers(@NonNull final FetchBeersCallback callback) {
        mRetrofitService.getBeers()
                .enqueue(new Callback<List<Beer>>() {
                    @Override
                    public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                        if (response.body() != null) {
                            callback.onBeersFetched(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Beer>> call, Throwable t) {
                        callback.onBeersFetchError();
                    }
                });
    }

    @Override
    public void searchBeerByName(String query, @NonNull final SearchBeerCallback callback) {
        mRetrofitService.searchBeerByName(query)
                .enqueue(new Callback<List<Beer>>() {
                    @Override
                    public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                        if (response.body() != null) {
                            callback.onSearchBeerSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Beer>> call, Throwable t) {
                        callback.onSearchBeerFailure();
                    }
                });
    }
}