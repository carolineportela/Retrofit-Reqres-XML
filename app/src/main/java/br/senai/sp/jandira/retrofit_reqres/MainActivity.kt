package br.senai.sp.jandira.retrofit_reqres

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
//import retrofit2.create
//import kotlin.math.log


class MainActivity : AppCompatActivity() {
    //lateinit pq vao ser assincronica
    //apiService esta recebendo a interface ApiService
    private lateinit var apiService: ApiService


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //apiService que foi criada ali em cima esta conectada com os endpoints
        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        //Botao de GET
         findViewById<Button>(R.id.btnGET).setOnClickListener{
             //Log.e("GETTING-DATA", "Teste de botao get")
             getUserByID()
    }

        //Botao de PUT
        findViewById<Button>(R.id.btnPUT).setOnClickListener{
            //Log.e("PUTTING-DATA", "Teste de botao put ")
            updateUser()
        }

        //Botao de DELETE
        findViewById<Button>(R.id.btnDELETE).setOnClickListener{
            //Log.e("DELETE-DATA", "Teste de botao delete ")
            deleteUser()
        }

        //Botao de POST
        findViewById<Button>(R.id.btnPOST).setOnClickListener{
            //Log.e("POSTING-DATA", "Teste de botao post ")
            createUser()
        }


    }

    //GetUserByID - chamada pros endpoints,funcao pra pegar o usuario pelo id
    //lISTAGEM DE USUARIO
    private fun getUserByID() {
        lifecycleScope.launch {
            val result = apiService.getUserByID("2")

            if(result.isSuccessful){
                Log.i("GETTING-DATA", "${result.body()?.data}")
            } else {
                Log.e("GETTING-DATA", "${result.message()}")
            }

        }
    }

    //INSERE USUARIO
    //funcao pra inserir um usuario
    private fun createUser(){
        lifecycleScope.launch {
            val body = JsonObject().apply{
                addProperty("name", "CAROL")
                addProperty("job", "CAROL ESTUDANTE DE TECNOLOGIA")
            }
            val result = apiService.createUser(body)

            if(result.isSuccessful){
                Log.i("CREATE-DATA", "${result.body()}")
            } else {
                Log.e("CREATE-DATA", "${result.message()}")
            }

        }
    }

    //ALTERA UM USUARIO
    //funcao para atualizar um user
    private fun updateUser(){
        lifecycleScope.launch {
            val body = JsonObject().apply{
                addProperty("name", "CAROL")
                addProperty("job", "CAROL ESTUDANTE DE TECNOLOGIA")
            }
            val result = apiService.updateUser("10", body)

            if(result.isSuccessful){
                Log.i("UPDATE-DATA", "${result.body()}")
            } else {
                Log.e("UPDATE-DATA", "${result.message()}")
            }

        }
    }

    //DELETA UM USUARIO
    //funcao para excluir um usuario
    private fun deleteUser(){
        lifecycleScope.launch {
            val result = apiService.deleteUser("2")

            if(result.isSuccessful){
                Log.i("DELETE-DATA", "${result}")
            } else {
                Log.e("DELETE-DATA", "${result.message()}")
            }

        }
    }
}