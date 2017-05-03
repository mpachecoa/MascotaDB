package com.example.sistema.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.example.sistema.mascotas.modelo.Mascota;

import java.util.ArrayList;

/**
 * Created by Sistema on 02/05/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTOPERFIL + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKE + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_ORDEN + " INTEGER" +
                ")";
        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                       " ORDER BY " + ConstantesBaseDatos.TABLE_MASCOTAS_ORDEN;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascota = new Mascota();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFotoPerfil(registros.getInt(2));
            mascota.setLike(registros.getInt(3));
            mascota.setOrden(registros.getInt(4));

            mascotas.add(mascota);

        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }

    public void InsertarUltimaMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        int minId = 0, maxId = 0, cantidad = 0, existeId = 0;


        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ") " +
                       "  FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                       " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + contentValues.get(ConstantesBaseDatos.TABLE_MASCOTAS_ID);

        Cursor registroExiste = db.rawQuery(query, null);

        if (registroExiste.moveToNext()) {
            existeId = registroExiste.getInt(0);
        }
        if (existeId>0) {
            Toast.makeText(context, "Mascota ya fue seleccionada", Toast.LENGTH_SHORT).show();
        } else {
            query = "SELECT MIN(" + ConstantesBaseDatos.TABLE_MASCOTAS_ORDEN + "), " +
                    "       MAX(" + ConstantesBaseDatos.TABLE_MASCOTAS_ORDEN + "), " +
                    "       COUNT(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ") " +
                    "  FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;


            Cursor registro = db.rawQuery(query, null);

            if (registro.moveToNext()) {
                minId = registro.getInt(0);
                maxId = registro.getInt(1);
                cantidad = registro.getInt(2);
            }
            if (cantidad>=5) {
                db.delete(ConstantesBaseDatos.TABLE_MASCOTAS,
                        ConstantesBaseDatos.TABLE_MASCOTAS_ORDEN + "=" + String.valueOf(minId),
                        null
                );
            }
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_ORDEN, maxId + 1);
            db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        }
        db.close();
    }
}
