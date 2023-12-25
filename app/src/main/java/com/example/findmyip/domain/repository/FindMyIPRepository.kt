package com.example.findmyip.domain.repository

import com.example.findmyip.data.remote.IPInfo
import retrofit2.Response

interface FindMyIPRepository {
    suspend fun getIpInfo(): Response<IPInfo>
}