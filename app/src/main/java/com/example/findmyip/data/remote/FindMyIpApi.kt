package com.example.findmyip.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface FindMyIpApi {
    @GET("json/")
    suspend fun getIpInfo(): Response<IPInfo>


    companion object {
        const val BASE_URL = "https://ipapi.co/"
    }
}