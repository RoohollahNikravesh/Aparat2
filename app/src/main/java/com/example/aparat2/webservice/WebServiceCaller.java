package com.example.aparat2.webservice;

import android.util.Log;

import com.example.aparat2.models.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebServiceCaller {
    IService iService;

    public WebServiceCaller() {
        iService=ApiClient.getRetrofit().create(IService.class);

    }
    public void getNewVideos(IMessageListener listener){
      Call<List<Video>>call= iService.ghjj();
      call.enqueue(new Callback<List<Video>>() {
          @Override
          public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
              listener.onSuccess(response.body());

          }

          @Override
          public void onFailure(Call<List<Video>> call, Throwable t) {
              listener.onFailure(t.getMessage().toString());

          }
      });
         
    }
    public void getSpecialVideo(IMessageListener listener){
        Call<List<Video>>call= iService.specialVideo();
        call.enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());

            }
        });

    }
}
