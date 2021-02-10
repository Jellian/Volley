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
    private lateinit var create:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Text=findViewById(R.id.Result)
        Create=findViewById(R.id.create)
        Update=findViewById(R.id.update)
        Delete=findViewById(R.id.delete)
        Read=findViewById(R.id.read)
        Username=findViewById(R.id.iduser)
        create=findViewById(R.id.usernew)

        val jsonobj=JSONObject()
        val url="https://quizapp3-55aa.restdb.io/rest/usersgame?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
        val queue=Volley.newRequestQueue(this)

        Create.setOnClickListener {
            jsonobj.put("name",create.text)
            val req=JsonObjectRequest(Request.Method.POST,url,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }

        Update.setOnClickListener {
            jsonobj.put("name", create.text)
            val id=Username.text
            val urlupdate="https://quizapp3-55aa.restdb.io/rest/usersgame/$id?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
            val req=JsonObjectRequest(Request.Method.PUT,urlupdate,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }

        Delete.setOnClickListener {
            val id=Username.text
            val urldelete="https://quizapp3-55aa.restdb.io/rest/usersgame/$id?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
            val req=JsonObjectRequest(Request.Method.DELETE,urldelete,jsonobj,Response.Listener {  },Response.ErrorListener {  })
            queue.add(req)
        }

        Read.setOnClickListener {
            val id=Username.text
            val urlget="https://quizapp3-55aa.restdb.io/rest/usersgame/$id?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
            val StringRequest= StringRequest(Request.Method.GET, urlget, Response.Listener { response ->
                val jsonObject=JSONObject(response)
                Text.text = jsonObject.get("name").toString()
            }, Response.ErrorListener {})
            queue.add(StringRequest)
        }

    }


}