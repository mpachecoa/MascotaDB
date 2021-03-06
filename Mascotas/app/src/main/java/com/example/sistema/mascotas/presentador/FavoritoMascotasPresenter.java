package com.example.sistema.mascotas.presentador;

import android.content.Context;

import com.example.sistema.mascotas.modelo.InteractorMascota;
import com.example.sistema.mascotas.modelo.Mascota;
import com.example.sistema.mascotas.vista.IFavoritoMascotasView;

import java.util.ArrayList;

/**
 * Created by Sistema on 02/05/2017.
 */

public class FavoritoMascotasPresenter implements IFavoritoMascotasPresenter{
    private IFavoritoMascotasView iFavoritoMascotasView;
    private Context context;
    private InteractorMascota interactorMascota;
    private ArrayList<Mascota> mascotas;

    public FavoritoMascotasPresenter(IFavoritoMascotasView iFavoritoMascotasView, Context context) {
        this.iFavoritoMascotasView = iFavoritoMascotasView;
        this.context = context;
        obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
        interactorMascota = new InteractorMascota(context);
        mascotas = interactorMascota.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iFavoritoMascotasView.inicializarAdaptadorRV(iFavoritoMascotasView.crearAdaptador(mascotas));
        iFavoritoMascotasView.generarLinearLayoutVertical();
    }
}
