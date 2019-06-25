package com.nocholla.recyclerview.dagger.dagger.module


import com.nocholla.recyclerview.dagger.dagger.scopes.ApplicationScope
import com.nocholla.recyclerview.dagger.retrofit.APIInterface
import com.nocholla.recyclerview.dagger.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    @ApplicationScope
    internal fun getApiInterface(retroFit: Retrofit): APIInterface {
        return retroFit.create(APIInterface::class.java!!)
    }

    @Provides
    @ApplicationScope
    internal fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @ApplicationScope
    internal fun getOkHttpCleint(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    internal val httpLoggingInterceptor: HttpLoggingInterceptor
        @Provides
        @ApplicationScope
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }

}
