package br.senai.sp.jandira.retrofit_reqres

import com.google.gson.annotations.SerializedName

//T = Generico

data class BaseResponse<T>(
    @SerializedName("data")
    var data: T? = null
)
