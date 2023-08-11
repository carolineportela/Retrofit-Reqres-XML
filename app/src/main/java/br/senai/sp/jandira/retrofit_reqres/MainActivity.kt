package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.create
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        //Botao de GET
         findViewById<Button>(R.id.btnGET).setOnClickListener{
             //Log.e("GETTING-DATA", "Teste de botao get")
             getUserByID()
    }

        //Botao de PUT
        findViewById<Button>(R.id.btnPUT).setOnClickListener{
            Log.e("PUTTING-DATA", "Teste de botao put ")
        }

        //Botao de DELETE
        findViewById<Button>(R.id.btnDELETE).setOnClickListener{
            Log.e("DELETE-DATA", "Teste de botao delete ")
        }

        //Botao de POST
        findViewById<Button>(R.id.btnDELETE).setOnClickListener{
            Log.e("POSTING-DATA", "Teste de botao post ")
        }


    }

    private fun getUserByID() {
        lifecycleScope.launch {
            val result = apiService.getUserByID("2")

            if(result.isSuccessful){
                Log.e("GETTING-DATA", "${result.body()?.data}")
            } else {
                Log.e("GETTING-DATA", "${result.message()}")
            }

        }
    }
}