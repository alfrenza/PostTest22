package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MovieNowPlaying {
    String endpoint = "https://api.themoviedb.org/3/movie/now_playing";

    String myToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMjMyNjc0OWUyOWFjZjBjNDRiZjhjOWIzYTc3NzMxNSIsInN1YiI6IjY0ZGNiZDE1ZDEwMGI2MTRiNGNjMzU1MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.XNi_pqA_124rcNJ9lVv-2yepMA98vJvvCbXH2zuT5aE";


    @Test
    public void testStatusCode(){
        RequestSpecification request = RestAssured.given();
        Response response = RestAssured.get(endpoint);
        request.header("Authorization", "Bearer "+myToken);
        request.header("Content-Type", "application/json");
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
