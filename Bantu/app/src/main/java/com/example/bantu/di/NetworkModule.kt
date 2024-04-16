package com.example.bantu.di
/*
import android.util.Log
import com.example.bantu.data.Remote.BantuApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val BASE_URL = "https://bantubackend-dev-tnqr.2.ie-1.fl0.io"

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val originalRequest = chain.request()

            val urlWithParams = originalRequest.url.newBuilder()
                .addQueryParameter(ACCESS_TOKEN, ACCESS_TOKEN)
                .build()

            val newRequest = originalRequest.newBuilder()
                .url(urlWithParams)
                .build()
            Log.w("PROVIDES", newRequest.toString())
            chain.proceed(newRequest)


        }.build()
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
    fun providesBantuApi(retrofit: Retrofit): BantuApi {
        return retrofit.create(BantuApi::class.java)
    }


}


 */