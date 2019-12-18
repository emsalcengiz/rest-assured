package com.emsalcengiz.odmbapi;
import com.emsalcengiz.omdbapi.model.DetailedListing;
import com.emsalcengiz.omdbapi.model.SearchResponse;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public interface Omdb {

    @GET("/")
    Call<SearchResponse> search(@QueryMap Map<String, String> queryMap);

    @GET("/")
    Call<DetailedListing> getDetailedListing(@QueryMap Map<String, String> queryMap);

}
