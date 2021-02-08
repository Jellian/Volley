package com.fiuady.volley

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.HttpResponse
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var Text:TextView
    private lateinit var response:HttpResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Text=findViewById(R.id.Result)
        val jsonobj=JSONObject()

        val url="https://quizapp-94e2.restdb.io/rest/usersgame?apikey=4ed1a1b9fe1c66b5df82ba8991f0e7c9a591d"
        val queue=Volley.newRequestQueue(this)


        val StringRequest= StringRequest(
            Request.Method.GET, url, Response.Listener { response ->
                Text.text = "${response}"
            },
            Response.ErrorListener {})
        queue.add(StringRequest)

        Text.setOnClickListener {
            jsonobj.put("name","hannia")
            jsonobj.put("puntos",10)

            val req=JsonObjectRequest(Request.Method.POST,url,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }
        
    }


}