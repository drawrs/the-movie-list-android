package com.khilman.www.boxoffice.InitRetrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 10/29/17.
 */

public class InitLibrary {
    public static String API_SERVER = "https://api.themoviedb.org/3/discover/";

    public static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(API_SERVER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static  APIServjces getInstance(){
        return setInit().create(APIServjces.class);
    }

}
