package com.example.sqlite_example

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyAdapter(var con:Context,var id:Array<String>,var name:Array<String>,var price:Array<String>):ArrayAdapter<String>(con,R.layout.list_item,name) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var inf=con.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
        var rview = inf.inflate(R.layout.list_item,null,true)

        var tid = rview.findViewById<TextView>(R.id.tvid)
        var tname = rview.findViewById<TextView>(R.id.tvname)
        var tprice = rview.findViewById<TextView>(R.id.tvprice)

        tid.text = id[position]
        tname.text = name[position]
        tprice.text = price[position]

        return rview
    }

}