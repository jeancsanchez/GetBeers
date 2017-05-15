package br.com.jeancarlos.beerlist;

import android.app.Application;

import br.com.jeancarlos.beerlist.injection.components.BeerRepositoryComponent;
import br.com.jeancarlos.beerlist.injection.components.DaggerBeerRepositoryComponent;
import br.com.jeancarlos.beerlist.injection.modules.ApplicationModule;

/**
 * This class represents the Application
 *
 * @author Jean Carlos
 * @since 5/10/17
 */

public class App extends Application {
    private static BeerRepositoryComponent mBeerRepositoryComponent;

    public static BeerRepositoryComponent getBeerRepositoryComponent() {
        return mBeerRepositoryComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initDaggerComponents();
    }

    private void initDaggerComponents() {
        mBeerRepositoryComponent = DaggerBeerRepositoryComponent
                .builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .build();


    }
}
