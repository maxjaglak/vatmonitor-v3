package oo.max.vatmonitor3.core.apifactory

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import oo.max.vatmonitor3.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiClientFactory @Inject constructor() {

    fun <T: Any> createApiClient(clazz: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.mfApiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient()!!)
                .build()

        return retrofit.create(clazz)
    }

    private fun okHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build()
    }

}