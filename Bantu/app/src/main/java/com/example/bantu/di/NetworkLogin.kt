package com.example.bantu.di

import android.util.Log
import com.example.bantu.AppClass.Companion.prefRepository
import com.example.bantu.Domain.Model.AuthResponse
import com.example.bantu.data.Remote.BantuApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkLogin {

    private const val BASE_URL = "https://bantubackend-dev-tnqr.2.ie-1.fl0.io"

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun provideBantuApi(retrofit: Retrofit): BantuApi {
        val retorno = retrofit.create(BantuApi::class.java)
        return retorno
    }
}
