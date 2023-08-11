package br.senai.sp.jandira.retrofit_reqres

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    //url de base/padrao
    private const val baseurl = "https://www.reqres.in"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}