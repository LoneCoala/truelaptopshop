package com.example.truelaptopshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import okhttp3.Callback
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        TextView = findViewById(R.id.TextData)
        buttonGet = findViewById(R.id.btnGet)
        buttonGet!!.setOnClickListener{TextView!!.text = "dasdasd"
*/


        val ServiceGenerator = ServiceGenerator.buildService(ApiInterface::class.java)
        val call = ServiceGenerator.getPosts()

        val btnGet = findViewById<Button>(R.id.btnGet)
        btnGet.setOnClickListener {
            call.enqueue(object: retrofit2.Callback<MutableList<PostModel>>{
                override fun onResponse(
                    call: Call<MutableList<PostModel>>,
                    response: Response<MutableList<PostModel>>
                ) {
                    if (response.isSuccessful()){
                        Log.e("sucess", response.body().toString())
                    }
                }


                override fun onFailure(call: Call<MutableList<PostModel>>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("error", t.message.toString())

                }

            })
        }
    }
}

private fun <T> Call<T>.enqueue(any: Any) {

}
