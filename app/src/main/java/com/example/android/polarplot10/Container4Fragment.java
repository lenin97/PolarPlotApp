package com.example.android.polarplot10;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Container4Fragment extends android.support.v4.app.Fragment implements View.OnClickListener {


    public Container4Fragment() {
        // Required empty public constructor
    }

    Button btn_seguir;
    Button btn_atras;
    Comunicador3 comunicador3;
    int i1 = 1 , i2=2;

    public interface Comunicador3 {
        public void enviar3(int nr2);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = (View) inflater.inflate(R.layout.fragment_container4, container, false);
        btn_seguir = (Button) v1.findViewById(R.id.id_btn_Siguiente);
        btn_seguir.setOnClickListener(this);

        btn_atras = (Button)v1.findViewById(R.id.id_btn_Atras);
        btn_atras.setOnClickListener(this);

        return v1;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_Siguiente:
                comunicador3.enviar3(i1);//envia la confirmacion al main
                break;
            case R.id.id_btn_Atras:
                comunicador3.enviar3(i2);//avisa al main para ir a la pagina de inicio
                break;

        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            comunicador3 = (Comunicador3) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}