package com.example.sistema.mascotas.modelo;

import android.content.ContentValues;
import android.content.Context;

import com.example.sistema.mascotas.R;
import com.example.sistema.mascotas.db.BaseDatos;
import com.example.sistema.mascotas.db.ConstantesBaseDatos;

import java.util.ArrayList;

/**
 * Created by Sistema on 02/05/2017.
 */

public class InteractorMascota {
    private static final int LIKE = 1;
    private Context context;

    public InteractorMascota(Context context)
    {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerMascotas();
    }

    public void insertarUltimaMascota(Mascota mascota){
        
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ID, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOPERFIL, mascota.getFotoPerfil());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, mascota.getLike());
        BaseDatos db = new BaseDatos(context);
        db.InsertarUltimaMascota(contentValues);
    }
}
