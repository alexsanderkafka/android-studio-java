package com.kafka.teste.appempresadeconsultoria.ui.servico;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ServicoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ServicoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}