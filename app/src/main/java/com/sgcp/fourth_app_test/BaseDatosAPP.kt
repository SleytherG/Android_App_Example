package com.sgcp.fourth_app_test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosAPP(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int ):
    SQLiteOpenHelper(context, name, factory, version) {

    val create_users_table = "CREATE TABLE Usuarios" +
                             "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                             "NOMBRE TEXT," +
                             "PASSWORD TEXT)";
//    val insert_data_table_users = "INSERT INTO Usuarios (ID, NOMBRE, PASSWORD) VALUES (1, 'Sleyther', '1234')";

    val create_tareas_table = "CREATE TABLE Tareas" +
                              "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                              "NOMBRE TEXT,"+
                              "DESCRIPCION TEXT,"+
                              "IMAGEN INT,"+
                              "USER INT)";

    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL(create_users_table);
        database?.execSQL(create_tareas_table);

        database?.execSQL(tareasPrincipales);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    val tareasPrincipales = "INSERT INTO Tareas (ID, NOMBRE, DESCRIPCION, IMAGEN, USER) VALUES " +
                            "(1, 'Limpiar el puente', 'El puente esta sucio debemos limpiarlo bien.', "+R.mipmap.img_2+", 1)," +
                            "(2, 'Limpiar la playa', 'La playa tiene plastico.', "+R.mipmap.img_3+", 2)," +
                            "(3, 'Meditar', 'Haz hecho demasiado el dia de hoy toca descansar un poco.', "+R.mipmap.img_6+", 1)," +
                            "(4, 'Hacer guardia en el camino', 'Necesitamos revisar el camino.', "+R.mipmap.img_8+", 3)," +
                            "(5, 'Cortar flores', 'Las flores estan muy grandes hay que cortarlas.', "+R.mipmap.img_9+", 1);";
}