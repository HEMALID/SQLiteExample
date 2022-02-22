package com.example.sqlite_example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtid =findViewById<EditText>(R.id.edPid)
        var txtname = findViewById<EditText>(R.id.edPname)
        var txtprice = findViewById<EditText>(R.id.edPprice)

        var bsave =findViewById<Button>(R.id.btnSave)
        bsave.setOnClickListener {

            var vid = txtid.text.toString()
            var vname =txtname.text.toString()
            var vprice = txtprice.text.toString()

            var dhandler:DatabaseHelperClass = DatabaseHelperClass(this)
            dhandler.addProduct(Product(Integer.parseInt(vid),vname,Integer.parseInt(vprice)))
            Toast.makeText(applicationContext, "Record Saved", Toast.LENGTH_SHORT).show()

            txtid.text.clear()
            txtname.text.clear()
            txtprice.text.clear()

        }
        var bView =findViewById<Button>(R.id.btnView)
        bView.setOnClickListener {
            var i=Intent(applicationContext,ViewData::class.java)
            startActivity(i)
        }
    }
}