package com.kafka.teste.appempresadeconsultoria.ui.contato;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ContatoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContatoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}