import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

//package com.app.android.library.net
//
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//
//object NetUtils {
//
//
//    fun getRetrofit(baseUrl: String): Retrofit {
////        var client =  OkHttpClient.Builder()
////            .connectTimeout(15, TimeUnit.SECONDS)
////            .readTimeout(15, TimeUnit.SECONDS)
////            .writeTimeout(15, TimeUnit.SECONDS)
////            .addInterceptor( HttpLoggingInterceptor())// 在此处添加拦截器即可，默认日志级别为BASIC
////            .build();
////        var retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
//////            .addCallAdapterFactory()
////            .baseUrl(baseUrl)
////            .client(client).build();
////        return retrofit
//
//
//        val logging = HttpLoggingInterceptor()
//        logging.level = HttpLoggingInterceptor.Level.BODY
//        val httpClient = OkHttpClient.Builder()
//        httpClient.addInterceptor(logging) // <-- this is the important line!
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(httpClient.build())
//            .build()
//        return retrofit
//    }
//
//}


//@GET(Api.pc28.orderHistory)
//fun orderHistory(@Header("token") token :String, @Path("pageNum") pageNum: Int, @Path("pageCount") pageCount: Int): Call<BaseResponse<OrderHistoryModel>>