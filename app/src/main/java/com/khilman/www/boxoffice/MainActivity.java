package com.khilman.www.boxoffice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.khilman.www.boxoffice.InitRetrofit.APIServjces;
import com.khilman.www.boxoffice.InitRetrofit.InitLibrary;
import com.khilman.www.boxoffice.Responses.ResponseMovie;
import com.khilman.www.boxoffice.Responses.ResultsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

       getMovie();

    }

    private void getMovie() {
        APIServjces api = InitLibrary.getInstance();

        String api_key = "873338d9ddae0acc77e331b844c7309f";
        String sort_by = "popularity.desc";

        Call<ResponseMovie> call = api.request_movie(sort_by, api_key);

        // kirim requestnya
        call.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                if (response.isSuccessful()){
                    List<ResultsItem> data_movie = response.body().getResults();

                    // kirim ke adapter recycler view
                    CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(MainActivity.this, data_movie);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
