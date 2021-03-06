package com.example.domain.usecases;

import android.support.annotation.NonNull;

import com.example.domain.BeersRepository;
import com.example.domain.models.Beer;

import javax.inject.Inject;

/**
 * @author Jean Carlos
 * @since 5/16/17
 */

public class DisfavorUseCase {
    private final BeersRepository mBeersRepository;

    @Inject
    public DisfavorUseCase(@NonNull BeersRepository beersRepository) {
        this.mBeersRepository = beersRepository;
    }


    /**
     * Executes the use case: Disfavor a beer
     *
     * @param beer The beer
     */
    public void executeUseCase(Beer beer) {
        beer.setFavorite(false);
        mBeersRepository.removeFavoriteBeer(beer);
    }
}
