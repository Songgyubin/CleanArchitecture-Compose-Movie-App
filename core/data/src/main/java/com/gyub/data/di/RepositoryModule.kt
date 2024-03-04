package com.gyub.data.di

import com.gyub.data.repository.MovieListsRepositoryImpl
import com.gyub.domain.movies.repository.MovieListsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Repository Module
 *
 * @author   Gyub
 * @created  2024/03/04
 */
@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindMovieListsRepository(movieListsRepositoryImpl: MovieListsRepositoryImpl): MovieListsRepository
}