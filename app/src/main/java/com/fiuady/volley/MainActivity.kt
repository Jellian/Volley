package com.fiuady.volley

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
    private lateinit var Create:Button
    private lateinit var Update:Button
    private lateinit var Delete:Button
    private lateinit var Read:Button
    private lateinit var Username:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Text=findViewById(R.id.Result)
        Create=findViewById(R.id.create)
        Update=findViewById(R.id.update)
        Delete=findViewById(R.id.delete)
        Read=findViewById(R.id.read)
        Username=findViewById(R.id.username)

        val jsonobj=JSONObject()
        val url="https://quizapp-94e2.restdb.io/rest/usersgame?apikey=4ed1a1b9fe1c66b5df82ba8991f0e7c9a591d"
        val queue=Volley.newRequestQueue(this)


        Create.setOnClickListener {
            jsonobj.put("name",Username.text)
            val req=JsonObjectRequest(Request.Method.POST,url,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }

        Update.setOnClickListener {
            jsonobj.put("name",Username.text)
            val req=JsonObjectRequest(Request.Method.PUT,url,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }

        Delete.setOnClickListener {
            jsonobj.put("name",Username.text)
            val req=JsonObjectRequest(Request.Method.DELETE,url,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }

        Read.setOnClickListener {
            val StringRequest= StringRequest(Request.Method.GET, url, Response.Listener { response ->
                Username.text
                Text.text = "${response}"
            }, Response.ErrorListener {})
            queue.add(StringRequest)
        }

        
    }


}