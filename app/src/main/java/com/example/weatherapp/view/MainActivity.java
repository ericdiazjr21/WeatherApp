package com.example.weatherapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.weatherapp.R;
import com.example.weatherapp.adapter.WeatherAdapter;
import com.example.weatherapp.model.WeatherResponse;
import com.example.weatherapp.viewModel.WeatherViewModel;

public class MainActivity extends AppCompatActivity {

    private WeatherViewModel weatherViewModel;
    private SearchView searchView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setSearchView();
        setViewModelAndObservable();
    }

    private void setSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                weatherViewModel.requestNewLocationWeather(s);
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void findViews() {
        recyclerView = findViewById(R.id.recycler_view);
        searchView = findViewById(R.id.location_search_view);
    }

    private void setViewModelAndObservable() {
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        weatherViewModel.getWeatherResponseLiveData().observe(this, new Observer<WeatherResponse>() {
            @Override
            public void onChanged(@Nullable WeatherResponse weatherResponse) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
                recyclerView.setAdapter(new WeatherAdapter(weatherResponse.getResponse()[0].getPeriods()));
            }
        });
    }
}
