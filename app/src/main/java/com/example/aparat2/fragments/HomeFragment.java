package com.example.aparat2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aparat2.R;
import com.example.aparat2.adapters.VideosAdapter;
import com.example.aparat2.databinding.FragmentHomeBinding;
import com.example.aparat2.models.Video;
import com.example.aparat2.webservice.IMessageListener;
import com.example.aparat2.webservice.WebServiceCaller;

import java.util.List;

public class HomeFragment extends Fragment {
FragmentHomeBinding binding;
WebServiceCaller webServiceCaller;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(getLayoutInflater());

        webServiceCaller=new WebServiceCaller();
        webServiceCaller.getNewVideos(new IMessageListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                binding.rvHomeNewVideo.setAdapter(new VideosAdapter(getActivity(),(List<Video>) ResponseMessage));
                binding.rvHomeNewVideo.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
                Log.e("","");
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("","");
            }
        });
        webServiceCaller.getSpecialVideo(new IMessageListener() {
            @Override
            public void onSuccess(Object ResponseMessage) {
                binding.rvHomeSpecialVideo.setAdapter(new VideosAdapter(getActivity(), (List<Video>) ResponseMessage));
                binding.rvHomeSpecialVideo.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        return binding.getRoot();
    }
}