package com.dilfa.absensi

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        //deklarasi database_name dan database_version
        private const val DATABASE_NAME = "Mahasiswa.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //membuat table
        val createTableQuery = "CREATE TABLE tb_absen(nim INTEGER PRIMARY KEY, nama TEXT, ket TEXT)"
        //pointer ? untuk memeriksa apakah db bernilai null sebelum mengeksekusi perintah execSQL(crateTableQuery)
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //meng-handle pembaruan bila dibutuhkan
        val dropTableQuery = "DROP TABLE IF EXISTS tb_absen"
        db.execSQL(dropTableQuery)
        onCreate(db)
    }
}