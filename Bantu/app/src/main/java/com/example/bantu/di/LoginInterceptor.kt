package com.example.bantu.di

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.Request

class LoginInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        // Aquí puedes modificar la solicitud según sea necesario, por ejemplo, agregar encabezados personalizados
        val modifiedRequest: Request = request.newBuilder()
            .build()

        // Procesar la solicitud modificada
        val response: Response = chain.proceed(modifiedRequest)

        // Aquí puedes procesar la respuesta según sea necesario

        return response
    }
}