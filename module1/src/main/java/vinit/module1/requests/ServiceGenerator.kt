package com.signify.indoor_navigation.site_enabler.requests

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vinit.commonproject.requests.NetworkConnectionInterceptor
import vinit.module1.requests.ApiInterface
import java.util.concurrent.TimeUnit


object ServiceGenerator {

    fun requestApi(mContext: Context): ApiInterface {
        var apiUrl = ""


        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(NetworkConnectionInterceptor(mContext))
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build()
            )
            .build()
            .create(ApiInterface::class.java)

    }
}
