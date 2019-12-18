package com.emsalcengiz.odmbapi;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class OmdbAPIFactory {

    private OmdbAPIFactory() {}


    private static retrofit() {
        return new given().when().get("http://www.omdbapi.com/?apikey=d782c83e&").then().statusCode(200);
    }


    public static OmdbAPI getOmdbAPI() {
        Omdb omdb = retrofit().create(Omdb.class);
        return new OmdbAPI(omdb);
    }

}

