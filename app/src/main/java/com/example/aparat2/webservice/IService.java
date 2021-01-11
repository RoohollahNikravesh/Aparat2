package com.example.aparat2.webservice;

import com.example.aparat2.models.Video;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {
    @GET("getNewVideos.php")
    Call<List<Video>>ghjj();
    @GET("getSpecial.php")
Call<List<Video>>specialVideo();
}
