package com.example.sistema.mascotas.vista;

import com.example.sistema.mascotas.adapter.FavoritoAdaptador;
import com.example.sistema.mascotas.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Sistema on 02/05/2017.
 */

public interface IFavoritoMascotasView {

    public void generarLinearLayoutVertical();

    public FavoritoAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(FavoritoAdaptador adaptador);
}
