package com.example.aparat2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.aparat2.adapters.TabsAdapter;
import com.example.aparat2.databinding.ActivityMainBinding;
import com.example.aparat2.fragments.CategoryFragment;
import com.example.aparat2.fragments.FavoriteFragment;
import com.example.aparat2.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
binding.bottomNavigationMain.setOnNavigationItemSelectedListener(this);
        List<Fragment>fragmentList=new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());
        TabsAdapter tabsAdapter=new TabsAdapter(getSupportFragmentManager(),fragmentList);
   binding.viewPagerMain.setAdapter(tabsAdapter);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_home:
                binding.viewPagerMain.setCurrentItem(0);
                binding.bottomNavigationMain.getMenu().findItem(R.id.item_home).setChecked(true);
                break;
            case R.id.item_category:
                binding.viewPagerMain.setCurrentItem(1);
                binding.bottomNavigationMain.getMenu().findItem(R.id.item_category).setChecked(true);
                break;
            case R.id.item_favorite:
                binding.viewPagerMain.setCurrentItem(2);
                binding.bottomNavigationMain.getMenu().findItem(R.id.item_favorite).setChecked(true);
                break;
        }
        return false;
    }
}