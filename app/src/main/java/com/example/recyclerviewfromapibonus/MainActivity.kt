package com.example.recyclerviewfromapibonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var al:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)
        al = arrayListOf()
        GetNames()
        rv.adapter = MyAdapter(al)
        rv.layoutManager = LinearLayoutManager(this)
    }

    fun GetNames(){
        val apiInterfac = Constants.apiInterface
        if (apiInterfac!=null) {
            apiInterfac.getNames()?.enqueue(object : retrofit2.Callback<Item> {
                override fun onResponse(call: Call<Item>, response: Response<Item>) {
                    var item = response.body()
                    if (item != null) {
                        for (i in 0 until item.size) {
                            var name = item[i].name
                            al.add(name)
                        }
                        rv.adapter?.notifyDataSetChanged()

                    }
                }

                override fun onFailure(call: Call<Item>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })



        }
    }
}