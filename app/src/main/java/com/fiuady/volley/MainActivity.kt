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
        val url="https://quizapp-9447.restdb.io/rest/usersgame?apikey=80712b96a00656ac172af57f7829d7678c923"
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
            }, Response.ErrorListener {})
            queue.add(StringRequest)
        }

    }


}