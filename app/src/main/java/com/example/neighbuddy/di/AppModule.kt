package com.example.neighbuddy.di

import android.app.Application
import com.example.neighbuddy.data.remote.MyApi
import com.example.neighbuddy.data.repository.MyRepositoryImpl
import com.example.neighbuddy.domain.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMyApi(): MyApi {
        return Retrofit.Builder().baseUrl("https://example.com").build().create(MyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyApi, app: Application): MyRepository {
        return MyRepositoryImpl(api, app)
    }
}