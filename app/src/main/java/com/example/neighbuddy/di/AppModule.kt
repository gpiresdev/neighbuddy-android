package com.example.neighbuddy.di

import android.app.Application
import com.example.neighbuddy.BuildConfig
import com.example.neighbuddy.data.remote.MyApi
import com.example.neighbuddy.data.repository.MyRepositoryImpl
import com.example.neighbuddy.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideMyApi(okHttpClient: OkHttpClient): MyApi {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://localhost:3000").client(okHttpClient).build().create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi, app: Application): MyRepository {
        return MyRepositoryImpl(api, app)
    }

    @Provides
    fun provideIDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}