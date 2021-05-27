package com.example.start.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.start.R;

public class MainFragment extends Fragment {

    //Declarar variables
    Button btnAbrir;

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.main_fragment, container, false);

        //Codigo a implementar

        //Referencias al boton
        btnAbrir = vista.findViewById(R.id.btnabrir);

        //llamamos al evento onClick cada vez que presiona el boton
        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implementamos codigo que se hara al presionar boton

                Dialog dialog = new Dialog(getActivity(), R.style.Theme_dialogo ); // llamamos al style que creamos
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                //referenciamos al layout que creamos que se llama dialogo_comentar
                dialog.setContentView(R.layout.dialogo_comentar);

                //Asignamos el dialogo transparente
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                //Declaramos variables del layout  (puedes declarar mas variables aqui)
                Button btnComentar = dialog.findViewById(R.id.DIbtnComentar);

                //Accion del boton
                btnComentar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "Hola mi dialogo , comentario", Toast.LENGTH_SHORT).show();

                    }
                });
                //fin de la accion del boton

                //Mostramos dialogo
                dialog.show();

            }
        });



        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}