package br.senai.sp.jandira.retrofit_reqres

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

//aqui sera chamado as api

interface ApiService {

    //chamada GET
    @GET("api/users/{id}")
    suspend fun getUserByID(@Path("id")id:String): Response<BaseResponse<UserResponse>>

    //chamada post
    @POST("api/users/")
    suspend fun createUser(@Body body: JsonObject) : Response<JsonObject>

    //chamada put precisa passar o id e o body da requisicao
    @PUT("api/users/{id}")
    suspend fun updateUser(
        @Path("id")id: String,
        @Body body: JsonObject
    ) : Response <JsonObject>

    @DELETE("api/users/{id}")
    suspend fun deleteUser (@Path("id") id: String): Response <JsonObject>
}