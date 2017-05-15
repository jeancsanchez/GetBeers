package br.com.jeancarlos.beerlist.data.beerlist;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.jeancarlos.beerlist.data.BeersDataSource;
import br.com.jeancarlos.beerlist.data.BeersRepository;
import br.com.jeancarlos.beerlist.features.beerslist.domain.usecases.GetBeerByNameUseCase;

import static org.mockito.Mockito.verify;

/**
 * This class makes tests for {@link GetBeerByNameUseCase}
 *
 * @author Jean Carlos
 * @since 5/15/17
 */

public class GetBeerByNameUseCaseTest {
    @Mock
    private BeersRepository mBeerRepository;

    @Mock
    private BeersDataSource.SearchBeerCallback mSearchBeerCallback;

    private GetBeerByNameUseCase mGetBeerByNameUseCase;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mGetBeerByNameUseCase = new GetBeerByNameUseCase(mBeerRepository);
    }

    @Test
    public void executeGetAllBeerUseCase() {
        String query = "Skol";
        mGetBeerByNameUseCase.executeUseCase(query, mSearchBeerCallback);
        verify(mBeerRepository).searchBeerByName(query, mSearchBeerCallback);
    }
}