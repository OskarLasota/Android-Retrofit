package com.example.retrofit;


import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Models.api.ApiResult;
import com.example.retrofit.Models.api.JsonPlaceHolderApi;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=f9cc014fa76b098f9e82f1c288379ea1&tags=kitten&page=1&format=json&nojsoncallback=1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        getImages();

    }


    private void getImages(){
        Call<ApiResult> call = jsonPlaceHolderApi.getImages("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=f9cc014fa76b098f9e82f1c288379ea1&tags=kitten&page=1&format=json&nojsoncallback=1/");
        call.enqueue(new Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {
                if(!response.isSuccessful()){
                    System.out.println("here "+ response.code());
                    return;
                }
                System.out.println("success");
                System.out.println(response.body().toString());

                ApiResult example = response.body();
                System.out.println(example.getPhotos().getPhotos().size());


            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {
                System.out.println("here failure");
                textViewResult.setText(t.getMessage());
            }
        });
    }

}
