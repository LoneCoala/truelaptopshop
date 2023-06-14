package com.example.truelaptopshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import okhttp3.Callback
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)


/*
        setContentView(R.layout.list_item)
*/
        /*
        TextView = findViewById(R.id.TextData)
        buttonGet = findViewById(R.id.btnGet)
        buttonGet!!.setOnClickListener{TextView!!.text = "dasdasd"
*/


        val ServiceGenerator = ServiceGenerator.buildService(ApiInterface::class.java)
        val call = ServiceGenerator.getPosts()
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)


        call.enqueue(object: retrofit2.Callback<MutableList<PostModel>>{
            override fun onResponse(
                call: Call<MutableList<PostModel>>,
                response: Response<MutableList<PostModel>>
            ) {
                if (response.isSuccessful()){

                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        setHasFixedSize(true)
                        adapter = PostAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())

            }

        })


    }
}

private fun <T> Call<T>.enqueue(any: Any) {

}
