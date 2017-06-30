package com.feinno.marketingdemo.data.net

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @project: KotlinMvpDemo
 * @description:网络管理
 * @author zzy05 zhangzhanyong@feinno.com
 * @date 2017/6/27 11:52
 * @updateUser zzy05
 * @update 2017/6/27 11:52
 * @version V1.0
 */
object ServiceFactory {

            private const val BASE_URL = "http://10.10.202.144:19020/"
//    private const val BASE_URL = "http://10.10.24.183:19020/"

    private const val BASE_URL_IMAGE = "http://10.10.202.144:19020/marketPlat/file/"

    private fun getLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    val serviceActivity: ServiceActivity by lazy {
        createRetrofitService(ServiceActivity::class.java)
    }

    fun <T> createRetrofitService(clazz: Class<T>): T {
        val builder = OkHttpClient.Builder().addInterceptor(getLogInterceptor()).readTimeout(100000, TimeUnit.SECONDS).connectTimeout(100000, TimeUnit.SECONDS)
        val retro = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(builder.build()).build()
        return retro.create(clazz)
    }

    fun getBaseImageUrl(): String {
        return BASE_URL_IMAGE
    }
}