package com.sgcp.fourth_app_test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosAPP(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int ):
    SQLiteOpenHelper(context, name, factory, version) {

    val create_users_table = "CREATE TABLE Usuarios" +
                             "(ID INT PRIMARY KEY," +
                             "NOMBRE TEXT," +
                             "PASSWORD TEXT)";
//    val insert_data_table_users = "INSERT INTO Usuarios (ID, NOMBRE, PASSWORD) VALUES (1, 'Sleyther', '1234')";

    override fun onCreate(database: SQLiteDatabase?) {
        database?.execSQL(create_users_table);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}