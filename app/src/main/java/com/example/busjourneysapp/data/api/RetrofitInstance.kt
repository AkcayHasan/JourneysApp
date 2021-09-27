package com.example.busjourneysapp.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    private var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit {
        return when {
            retrofit == null -> getRetrofit(baseUrl)
            retrofit!!.baseUrl().encodedPath != baseUrl -> getRetrofit(baseUrl)
            else -> retrofit!!
        }
    }

    private fun getRetrofit(baseUrl: String): Retrofit {

        val headerInterceptor = Interceptor { chain ->
            val original = chain.request()

            original.newBuilder()
                .addHeader("Content-Type", "application/json")
                //.addHeader("Authorization", "Basic JEcYcEMyantZV095WVc3G2JtVjNZbWx1")
                .build()

            chain.proceed(original)
        }

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }


}