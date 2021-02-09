package com.fiuady.volley

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.*
import org.json.JSONArray
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
        val url="https://quizapp3-55aa.restdb.io/rest/usersgame?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
        val queue=Volley.newRequestQueue(this)


        Create.setOnClickListener {
            jsonobj.put("name",Username.text)
            val req=JsonObjectRequest(Request.Method.POST,url,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }

        Update.setOnClickListener {
            jsonobj.put("id",Username.text)
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
                val jsonArray=JSONArray(response)
                val i= Username.text.toString().toInt()
                val jsonObject=JSONObject(jsonArray.getString(i))
                Text.text = jsonObject.get("name").toString()
            }, Response.ErrorListener {})
            queue.add(StringRequest)
        }

    }


}