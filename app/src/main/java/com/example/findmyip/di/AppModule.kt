package com.example.findmyip.di

import android.app.Application
import com.example.findmyip.data.remote.FindMyIpApi
import com.example.findmyip.domain.repository.FindMyIPInfoRepositoryImpl
import com.example.findmyip.domain.repository.FindMyIPRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(FindMyIpApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideFindMyIDApi(retrofit: Retrofit): FindMyIpApi {
        return retrofit.create(FindMyIpApi::class.java)
    }


    @Provides
    @Singleton
    fun provideFindMyIpRepository(
        api: FindMyIpApi,
    ) = FindMyIPInfoRepositoryImpl(api) as FindMyIPRepository
}