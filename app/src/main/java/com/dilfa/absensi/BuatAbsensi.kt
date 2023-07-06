package com.dilfa.absensi

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class BuatAbsensi : AppCompatActivity() {

    private lateinit var nimedit : EditText
    private lateinit var namaedit : EditText
    private lateinit var ketedit : EditText
    private lateinit var simpan : Button

    private lateinit var dataHelper: DataHelper
    private lateinit var db: SQLiteDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_absensi)

        nimedit = findViewById(R.id.NimEdit)
        namaedit = findViewById(R.id.NamaEdit)
        ketedit = findViewById(R.id.inputKet)
        simpan = findViewById(R.id.buttonSimpan)

        dataHelper = DataHelper(this)
        db = dataHelper.writableDatabase

        simpan.setOnClickListener {
            val nim = nimedit.text.toString()
            val nama = namaedit.text.toString()
            val ket = ketedit.text.toString()

            val contentValues = ContentValues()
            contentValues.put("nim", nim)
            contentValues.put("nama", nama)
            contentValues.put("ket", ket)

            db.insert("tb.absensi", null, contentValues)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}