package com.lakelab.android.networkdebugsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.lakelab.android.network.BaseNetworkTools
import com.lakelab.android.network.GlideApp
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    companion object {
        private const val SAMPLE_IMAGE_ICON =
            "https://github.com/LakeLab/lakelab.github.io/raw/master/assets/images/baseline_fingerprint_black_48dp.png"
        private const val SAMPLE_GET_URL =
            "https://dummy.restapiexample.com/api/v1/employees"
        private const val LOG_TAG = "TAAAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        am_button.setOnClickListener {
            GlideApp.with(this@MainActivity).load(SAMPLE_IMAGE_ICON)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true).into(am_sample_image)
            BaseNetworkTools.preparedOkHttpClient.newCall(
                Request.Builder().apply { this.url(SAMPLE_GET_URL) }.build()
            ).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.wtf(LOG_TAG, e)
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d(LOG_TAG, "result :" + response.body()?.string())
                }
            })
        }
    }
}
