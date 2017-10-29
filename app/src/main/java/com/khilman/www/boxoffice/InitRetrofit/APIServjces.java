package com.khilman.www.boxoffice.InitRetrofit;

import com.khilman.www.boxoffice.Responses.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by root on 10/29/17.
 */

public interface APIServjces {

    //movie?sort_by=popularity.desc&api_key=873338d9ddae0acc77e331b844c7309f&
    @GET("movie")
    Call<ResponseMovie> request_movie(
            @Query("sort_by") String sort_by,
            @Query("api_key") String api_key
    );

}
