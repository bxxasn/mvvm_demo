package com.demo.library.net;

import android.text.TextUtils;

import com.app.android.library.net.LiveDataCallAdapterFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cuiyan on 16/6/3 11:07
 * Email: cuiyan@rqb.com
 */
public class BaseServiceUtil {


   public static final String  BASE_URL = "";

    private static final int DEFAULT_TIMEOUT = 10;

    private static final Map<String, Object> serviceMap = new ConcurrentHashMap<>();


//    private static final CommonInterceptor interceptor = new CommonInterceptor();
//    private static final OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
//            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
//            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
//    // Retrofit要求baseUrl以 '/' 为结尾
//    private static final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    public static synchronized <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, null);
    }




    public static <T> T createService(Class<T> serviceClass, String baseUrl) {
        T value;
        if (serviceMap.containsKey(baseUrl)) {
            Object obj = serviceMap.get(baseUrl);
            if (obj == null) {
                value = createRetrofit(serviceClass,baseUrl);
                serviceMap.put(baseUrl, value);
            } else {
                value = (T) obj;
            }
        } else {
            value = createRetrofit(serviceClass,baseUrl);
            serviceMap.put(baseUrl, value);
        }
        return value;
    }

    private static <T> T createRetrofit(Class<T> clzz,String baseUrl){
        CommonInterceptor interceptor = new CommonInterceptor();
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        // Retrofit要求baseUrl以 '/' 为结尾
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
//        .addCallAdapterFactory(new LiveDataCallAdapterFactory());
        if (!TextUtils.isEmpty(baseUrl)) {
            retrofitBuilder.baseUrl(baseUrl);
        } else {
            retrofitBuilder.baseUrl(BASE_URL);
        }
        clientBuilder.interceptors().clear();
        clientBuilder.interceptors().add(interceptor);

        // 设置证书
//        try {
//            clientBuilder.sslSocketFactory(RqbTrustManager.getInstance().getSSLSocketFactory("BKS", R.raw.rqb_ssl));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        OkHttpClient client = clientBuilder.build();
        Retrofit retrofit = retrofitBuilder.client(client).build();
        return retrofit.create(clzz);
    }
}