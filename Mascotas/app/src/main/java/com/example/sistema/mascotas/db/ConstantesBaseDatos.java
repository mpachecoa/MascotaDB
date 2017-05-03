package com.example.sistema.mascotas.db;

import com.example.sistema.mascotas.modelo.FotoLike;

import java.util.ArrayList;

/**
 * Created by Sistema on 02/05/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS            = "mascotas";
    public static final String TABLE_MASCOTAS_ID         = "id";
    public static final String TABLE_MASCOTAS_NOMBRE     = "nombre";
    public static final String TABLE_MASCOTAS_FOTOPERFIL = "fotoPerfil";
    public static final String TABLE_MASCOTAS_LIKE       = "like";
    public static final String TABLE_MASCOTAS_ORDEN      = "orden";
}
