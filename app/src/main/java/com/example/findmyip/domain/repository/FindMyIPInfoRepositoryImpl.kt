package com.example.findmyip.domain.repository

import com.example.findmyip.data.remote.FindMyIpApi
import com.example.findmyip.data.remote.IPInfo
import retrofit2.Response
import javax.inject.Inject

class FindMyIPInfoRepositoryImpl @Inject constructor(private val api: FindMyIpApi) :
    FindMyIPRepository {
    override suspend fun getIpInfo(): Response<IPInfo> {
        return  api.getIpInfo()
    }
}