package br.com.jeancarlos.beerlist.features.favorites.presentation.adapters;

import android.content.Context;
import android.view.View;

import java.util.List;

import br.com.jeancarlos.beerlist.base.BaseView;
import br.com.jeancarlos.beerlist.features.beerslist.domain.model.Beer;
import br.com.jeancarlos.beerlist.features.beerslist.presentation.adapters.BeerAdapter;

/**
 * This class represents a item Beer on favorite list. This class extends {@link BeerAdapter}
 *
 * @author Jean Carlos
 * @since 5/16/17
 */

public class FavoriteAdapter extends BeerAdapter {

    public FavoriteAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindViewHolder(BeerViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);

        // hide the favorites item
        if (position == 0) {
            holder.itemView.setVisibility(View.GONE);
        }
    }

    @Override
    public void setOnBeerItemClickedListener(BaseView.OnBeerItemClickedListener onBeerItemClickedListener) {
        super.setOnBeerItemClickedListener(onBeerItemClickedListener);
    }

    @Override
    public void setupBeers(List<Beer> beersList) {
        super.setupBeers(beersList);
    }
}
