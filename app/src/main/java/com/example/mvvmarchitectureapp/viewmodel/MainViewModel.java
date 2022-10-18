package com.example.mvvmarchitectureapp.viewmodel;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmarchitectureapp.model.DataModel;

public class MainViewModel extends ViewModel {
    public final MutableLiveData<String> mData = new MutableLiveData<>();

    public final SingleLiveEvent<String> toastText = new SingleLiveEvent<>();

    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private final DataModel dataModel = new DataModel();

    public void refresh() {
        isLoading.set(true);

        dataModel.retrieveData(new DataModel.onDataReadyCallback() {
            @Override
            public void onDataReady(String data) {
                mData.setValue(data);
                toastText.setValue("下載完成");
                isLoading.set(false);
            }
        });
    }
}
