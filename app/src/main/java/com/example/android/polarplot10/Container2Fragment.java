package com.example.android.polarplot10;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Container2Fragment extends android.support.v4.app.Fragment implements View.OnClickListener{


    public Container2Fragment() {
        // Required empty public constructor
    }

    Button btn_nuevagrafica;
    Comunicador comunicador;
    int i1=1;

    public interface Comunicador{
        public void enviar(int nr);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v21= inflater.inflate(R.layout.fragment_container2, container, false);
        btn_nuevagrafica=(Button)v21.findViewById(R.id.btn_newPlot);
        btn_nuevagrafica.setOnClickListener(this);
        return v21;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_newPlot:
                comunicador.enviar(i1);//envia la data al main para q cambie al contenedor1 y el contenedor2
                break;

        }
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try {
            comunicador = (Comunicador) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


}
