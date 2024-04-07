package com.example.bantu.data.Remote

import com.example.bantu.di.NetworkModule
import javax.inject.Inject

class RemoteDataSource@Inject constructor(
    private val api: BantuApi,
    private val networkModule: NetworkModule
){

    suspend fun launchLogin(userName: String, password: String): String {
        //ESTE LLAMARA A NETWORKMODULE

        return ""
    }
}