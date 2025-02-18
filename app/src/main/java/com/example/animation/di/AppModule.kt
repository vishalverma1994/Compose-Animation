package com.example.animation.di

import com.example.animation.domain.repository.MyRepository
import com.example.animation.data.remote.MyAPI
import com.example.animation.data.repository.MyRepositoryImpl
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
    fun provideMyAPI(): MyAPI {
        return Retrofit.Builder().baseUrl("https://test.com").build().create(MyAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(api: MyAPI): MyRepository {
        return MyRepositoryImpl(api)
    }

}