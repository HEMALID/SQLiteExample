package com.example.sqlite_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class ViewData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)

        var dhandler:DatabaseHelperClass = DatabaseHelperClass(this)
        var pro:List<Product> = dhandler.viewProduct()

        var proid=Array<String>(pro.size){"0"}
        var proname=Array<String>(pro.size){"null"}
        var proprice=Array<String>(pro.size){"0"}
        var index=0
        for (i in pro)
        {
            proid[index]=i.pid.toString()
            proname[index]=i.pname
            proprice[index]=i.price.toString()

            index++
        }
        var ad=MyAdapter(this,proid,proname,proprice)
        var ls=findViewById<ListView>(R.id.productList)
        ls.adapter = ad
    }
}