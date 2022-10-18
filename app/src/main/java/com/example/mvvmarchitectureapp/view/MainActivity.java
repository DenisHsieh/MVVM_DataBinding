package com.example.mvvmarchitectureapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmarchitectureapp.viewmodel.MainViewModel;
import com.example.mvvmarchitectureapp.R;
import com.example.mvvmarchitectureapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        activityMainBinding.setViewModel(viewModel);

        viewModel.mData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String data) {
                activityMainBinding.txtHelloWord.setText(data);
            }
        });

        viewModel.toastText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String text) {
                Toast.makeText(MainActivity.this, "下載完成", Toast.LENGTH_SHORT).show();
            }
        });
    }
}