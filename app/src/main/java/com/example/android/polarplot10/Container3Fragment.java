package com.example.android.polarplot10;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Container3Fragment extends android.support.v4.app.Fragment implements View.OnClickListener{


    public Container3Fragment() {
        // Required empty public constructor
    }

    Comunicador2 comunicador2;
    Button btn_save;
    EditText et_a;
    EditText et_b;
    EditText et_c;
    EditText et_d;
    EditText et_e;
    EditText et_f;

    double ia,ib,ic,id,ie;
    double iif;

    public interface Comunicador2{
        public void enviar2(double ea,double eb,double ec, double ed,double ee, double ef);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try {
            comunicador2 = (Comunicador2) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= (View)inflater.inflate(R.layout.fragment_container3, container, false);
        et_a=(EditText)v1.findViewById(R.id.id_et_a);
        et_b=(EditText)v1.findViewById(R.id.id_et_b);
        et_c=(EditText)v1.findViewById(R.id.id_et_c);
        et_d=(EditText)v1.findViewById(R.id.id_et_d);
        et_e=(EditText)v1.findViewById(R.id.id_et_e);
        et_f=(EditText)v1.findViewById(R.id.id_et_f);

        btn_save=(Button)v1.findViewById(R.id.btn_id_save);
        btn_save.setOnClickListener(this);
        return v1;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_id_save:
                ia = Double.parseDouble(et_a.getText().toString());
                ib = Double.parseDouble(et_b.getText().toString());
                ic = Double.parseDouble(et_c.getText().toString());
                id = Double.parseDouble(et_d.getText().toString());
                ie = Double.parseDouble(et_e.getText().toString());
                iif = Double.parseDouble(et_f.getText().toString());
                comunicador2.enviar2(ia,ib,ic,id,ie,iif);//envia la data al main
                break;

        }
    }


}
