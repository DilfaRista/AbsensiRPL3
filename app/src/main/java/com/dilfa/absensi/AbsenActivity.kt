package com.dilfa.absensi

import android.content.Context
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.dilfa.absensi.DataHelper
import android.database.sqlite.SQLiteDatabase
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.CursorAdapter
import android.widget.TextView


class AbsenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen)

        val dataHelper = DataHelper(this)
        val db = dataHelper.readableDatabase

        val projection = arrayOf("nim", "nama", "ket")
        val cursor = db.query("tb.absensi", projection, null, null, null, null, null)

        val listView = findViewById<ListView>(R.id.List)
        val adapter = RecordAdapter(this, cursor)

        listView.adapter = adapter

        cursor?.close()
        db.close()
    }

    private class RecordAdapter(context:Context, cursor:Cursor?): CursorAdapter(context, cursor,0){


        override fun newView(context: Context, cursor: Cursor, parent: ViewGroup): View{
            return LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)
        }

        override fun bindView(view: View, context: Context, cursor: Cursor) {

            val nimTextview = view.findViewById<TextView>(R.id.text1)
            val namaTextview = view.findViewById<TextView>(R.id.text2)
            val ketTextview = view.findViewById<TextView>(R.id.text3)

            val nim = cursor.getInt(cursor.getColumnIndexOrThrow("nim"))
            val nama = cursor.getString(cursor.getColumnIndexOrThrow("nama"))
            val ket = cursor.getString(cursor.getColumnIndexOrThrow("ket"))

            nimTextview.text = "NIM : $nim"
            namaTextview.text = "NAMA : $nama"
            ketTextview.text = "KETERANGAN : $ket"
        }
    }
}