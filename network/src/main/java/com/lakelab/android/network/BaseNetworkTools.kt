package com.lakelab.android.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BaseNetworkTools {

    companion object {
        private const val DEFAULT_CONNECT_TIME_OUT_MILLIS: Long = 10 * 1000
        private const val DEFAULT_READ_TIME_OUT_MILLIS: Long = 10 * 1000
        private const val DEFAULT_WRITE_TIME_OUT_MILLIS: Long = 10 * 1000

        val preparedOkHttpClient = StethoUtils.makeBuilderWithStetho().build()

        fun makeGsonRetrofit(baseUrl: String, okHttpClient: OkHttpClient) =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(
                    GsonConverterFactory.create()
                ).client(okHttpClient).build()

    }
}