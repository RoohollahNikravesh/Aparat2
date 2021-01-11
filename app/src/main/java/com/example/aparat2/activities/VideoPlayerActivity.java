package com.example.aparat2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.aparat2.R;
import com.example.aparat2.databinding.ActivityVideoPlayerBinding;

public class VideoPlayerActivity extends AppCompatActivity {
ActivityVideoPlayerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}