package com.gyub.network.di

import com.gyub.network.retrofit.GenresService
import com.gyub.network.retrofit.MovieListsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

/**
 *  각 API Service 모듈
 *
 * @author   Gyub
 * @created  2024/03/02
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Singleton
    @Provides
    fun provideMovieListsService(retrofit: Retrofit.Builder): MovieListsService {
        return retrofit
            .build()
            .create()
    }

    @Singleton
    @Provides
    fun provideGenresService(retrofit: Retrofit.Builder): GenresService {
        return retrofit
            .build()
            .create()
    }

}