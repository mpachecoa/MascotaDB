package com.example.sistema.mascotas.vista.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.adapter.MascotaAdaptador;
import com.example.sistema.mascotas.modelo.FotoLike;
import com.example.sistema.mascotas.modelo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;


    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvMascotas = (RecyclerView) getActivity().findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<Mascota>();
        ArrayList<FotoLike> fotoslike;


        // Mascota 1
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 0));
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_perro1, 2));
        mascotas.add(new Mascota(1, "Tavo", R.drawable.ic_perro1, 80, fotoslike));

        // Mascota 2
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro2, 0));
        mascotas.add(new Mascota(2, "Blacky", R.drawable.ic_perro2, 50, fotoslike));

        // Mascota 3
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro3, 10));
        fotoslike.add(new FotoLike(R.drawable.ic_perro3, 9));
        fotoslike.add(new FotoLike(R.drawable.ic_perro3, 5));
        mascotas.add(new Mascota(3, "Mosha", R.drawable.ic_perro3, 34, fotoslike));

        // Mascota 4
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_gato1, 4));
        mascotas.add(new Mascota(4, "Rintintin", R.drawable.ic_gato1, 30, fotoslike));

        // Mascota 5
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato2, 5));
        mascotas.add(new Mascota(5, "Tifón", R.drawable.ic_gato2, 25, fotoslike));

        // Mascota 6
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_gato3, 10));
        fotoslike.add(new FotoLike(R.drawable.ic_gato3, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_gato3, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_gato3, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato3, 1));
        fotoslike.add(new FotoLike(R.drawable.ic_gato3, 4));
        mascotas.add(new Mascota(6, "Perla", R.drawable.ic_gato3, 21, fotoslike));


        // Mascota 7
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 9));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 10));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_gato4, 4));
        mascotas.add(new Mascota(7, "Osa", R.drawable.ic_gato4, 25, fotoslike));

        // Mascota 8
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 8));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 5));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 8));
        fotoslike.add(new FotoLike(R.drawable.ic_perro4, 4));
        mascotas.add(new Mascota(8, "Cachin", R.drawable.ic_perro4, 30, fotoslike));

        // Mascota 9
        fotoslike = new ArrayList<>();
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 8));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 3));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 4));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 6));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 8));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 9));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 2));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 10));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 8));
        fotoslike.add(new FotoLike(R.drawable.ic_perro5, 4));
        mascotas.add(new Mascota(9, "Boby", R.drawable.ic_perro5, 20, fotoslike));

    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }

}
