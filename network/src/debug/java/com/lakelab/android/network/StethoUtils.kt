package com.lakelab.android.network

import android.content.Context
import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient

class StethoUtils {
    companion object {
        @JvmStatic
        internal fun initStetho(context: Context) = Stetho.initializeWithDefaults(context)

        @JvmStatic
        internal fun makeBuilderWithStetho() =
                OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor())
    }
}