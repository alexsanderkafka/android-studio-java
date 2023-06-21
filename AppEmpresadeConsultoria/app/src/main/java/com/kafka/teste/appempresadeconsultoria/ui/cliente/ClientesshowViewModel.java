package com.kafka.teste.appempresadeconsultoria.ui.cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClientesshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ClientesshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}