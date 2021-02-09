package com.fiuady.volley

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.*
import com.mashape.unirest.http.Unirest
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var Text:TextView
    private lateinit var Create:Button
    private lateinit var Update:Button
    private lateinit var Delete:Button
    private lateinit var Read:Button
    private lateinit var Username:EditText
    private lateinit var Changename:EditText
    private lateinit var clave:TextView
    private lateinit var  response: HttpResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Text=findViewById(R.id.Result)
        Create=findViewById(R.id.create)
        Update=findViewById(R.id.update)
        Delete=findViewById(R.id.delete)
        Read=findViewById(R.id.read)
        Username=findViewById(R.id.username)
        Changename=findViewById(R.id.user)
        clave=findViewById(R.id.clave)

        val jsonobj=JSONObject()
        val url="https://quizapp3-55aa.restdb.io/rest/usersgame?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
        val queue=Volley.newRequestQueue(this)

        Create.setOnClickListener {
            jsonobj.put("name", Changename.text)
            val req=JsonObjectRequest(
                Request.Method.POST,
                url,
                jsonobj,
                Response.Listener { },
                Response.ErrorListener { })
            queue.add(req)
        }

        Update.setOnClickListener {
            jsonobj.put("id", Username.text)
            val req=JsonObjectRequest(
                Request.Method.PUT,
                url,
                jsonobj,
                Response.Listener { },
                Response.ErrorListener { })
            queue.add(req)
        }

        Delete.setOnClickListener {
            val id2=clave.text
            val url2="https://quizapp3-55aa.restdb.io/rest/usersgame/$id2?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
            val req=JsonObjectRequest(Request.Method.DELETE, url2, jsonobj, Response.Listener {}, Response.ErrorListener { })
            queue.add(req)
        }

        Read.setOnClickListener {

           val id=Username.text
           /* val response= Unirest.get("https://quizapp3-55aa.restdb.io/rest/usersgame?q={"id":$id}")
                .header("x-apikey", "93197c60759dca33a6dd2862665a0f9a900b9")
                .header("cache-control", "no-cache")
                .asString()
            var all =response.body
            var allres=JSONObject(all).getString("name")
            Text.text=allres.toString()*/
            
        val urlget="https://quizapp3-55aa.restdb.io/rest/usersgame?q={\"id\":$id}?apikey=93197c60759dca33a6dd2862665a0f9a900b9"
            val StringRequest= StringRequest(
                Request.Method.GET,
                urlget,
                Response.Listener<String> { response ->
                    val obj = JSONObject(response)
                    Text.text = obj.getString("name")
                },
                Response.ErrorListener {})
            queue.add(StringRequest)
        }

    }


}