package com.kafka.teste.appempresadeconsultoria.ui.servico;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kafka.teste.appempresadeconsultoria.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicoFragment extends Fragment {


    public ServicoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_servico, container, false);
    }

}
