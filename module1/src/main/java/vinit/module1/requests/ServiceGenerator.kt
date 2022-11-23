package vinit.module1.requests

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vinit.module1.BuildConfig
import java.util.concurrent.TimeUnit


object ServiceGenerator {

    fun requestApi(mContext: Context): ApiInterface {
        var apiUrl = BuildConfig.BASE_URL_EU_DEVELOPMENT


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
