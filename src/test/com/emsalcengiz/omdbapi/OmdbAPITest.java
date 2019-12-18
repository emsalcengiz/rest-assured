package com.emsalcengiz.omdbapi;
import com.emsalcengiz.omdbapi.model.DetailedListing;
import com.emsalcengiz.omdbapi.model.SearchResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class OmdbAPITest {

    private final static String title = "Harry Potter";
    private final static String imdbID = "tt0241527";
    private OmdbAPI omdbAPI;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        omdbAPI = OmdbAPIFactory.getOmdbAPI();
    }

    @Test
    public void searchWithTitle() throws Exception {
        Query query = new Query.Builder(title).build();
        SearchResponse searchResponse = omdbAPI.search(query);

        assertTrue(Boolean.valueOf(searchResponse.getResponse()));
        assertTrue(Integer.valueOf(searchResponse.getTotalResults()) > 0);
        System.out.println(searchResponse.getResponse());
    }

    @Test
    public void searchWithoutTitle() throws Exception {
        Query query = new Query.Builder(imdbID).build();
        exception.expect(OmdbException.class);
        exception.expectMessage("Query must contain title parameter for search.");
        omdbAPI.search(query);
    }

    @Test
    public void getDetailedListingWithTitle() throws Exception {
        Query query = new Query.Builder(title).build();
        DetailedListing movie = omdbAPI.getDetailedListing(query);

        assertEquals(title, movie.getTitle());
    }

    @Test
    public void getDetailedListingWithID() throws Exception {
        Query query = new Query.Builder(imdbID).build();
        DetailedListing movie = omdbAPI.getDetailedListing(query);

        assertEquals(imdbID, movie.getImdbID());
    }

}