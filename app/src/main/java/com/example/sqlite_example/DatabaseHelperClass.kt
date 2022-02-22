package com.example.sqlite_example

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception

class DatabaseHelperClass(con : Context):SQLiteOpenHelper(con, database_name,null, Database_Ver) {

    companion object{
        val Database_Ver=1
        val database_name="Product Details"
        val table_name="Product"
        val p_id="pid"
        val p_name="pname"
        val p_price="price"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        var ctable= ("create table " + table_name +"(" + p_id + " INTEGER PRIMARY KEY, " +p_name+ " TEXT ," + p_price +" INTEGER " + ")")
        p0!!.execSQL(ctable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("drop table if exists" + table_name)
        onCreate(p0)
    }

    fun addProduct(pro :Product){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(p_id,pro.pid)
        cv.put(p_name,pro.pname)
        cv.put(p_price,pro.price)
        db.insert(table_name,null,cv)
        db.close()
    }

    @SuppressLint("Range")
    fun viewProduct():List<Product>{

        var proList:ArrayList<Product> = ArrayList<Product>()
        var squery = "select * from $table_name"
        var db=this.readableDatabase
        var cur:Cursor?=null
        try {
            cur=db.rawQuery(squery,null)
        }catch (e:Exception){
            Log.e("DatabaseError","Error in the qyery")
        }

        var cpid:Int
        var cpname:String
        var cprice:Int
        if (cur!!.moveToFirst()){
            while (cur.moveToNext())
            {
                cpid = cur.getInt(cur.getColumnIndex(p_id))
                cpname = cur.getString(cur.getColumnIndex(p_name))
                cprice = cur.getInt(cur.getColumnIndex(p_price))

                var pro=Product(cpid,cpname,cprice)
                proList.add(pro)
            }
        }
        return proList
    }
}