package br.senai.sp.jandira.retrofit_reqres

import com.google.gson.annotations.SerializedName

//T = Generico

//manipulacao de dados

//SerializedName é data pq esta assim na api que estamos utilizando,e ela nasce sendo null.

data class BaseResponse<T>(
    @SerializedName("data")
    var data: T? = null
)
