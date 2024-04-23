package com.example.bantu.di

import android.util.Log
import com.example.bantu.AppClass.Companion.prefRepository
import com.example.bantu.data.Remote.BantuApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://bantubackend-dev-tnqr.2.ie-1.fl0.io"


    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val authToken = prefRepository.loadTokenPreferences(ACCESS_TOKEN)

        //Si no hay token en el preference, ejecuto el otro metodo de autenticacion.
        return if(authToken.isNotEmpty()) {
            OkHttpClient.Builder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val newRequest =
                    originalRequest.newBuilder().addHeader("Authorization", "Bearer $authToken").build()
                chain.proceed(newRequest)
            }.build()
        } else {
            OkHttpClient.Builder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val newRequest =
                    originalRequest.newBuilder().build()
                chain.proceed(newRequest)
            }.build()
        }
    }

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    @Provides
    fun provideBantuApi(retrofit: Retrofit): BantuApi {
        return retrofit.create(BantuApi::class.java)
    }


}