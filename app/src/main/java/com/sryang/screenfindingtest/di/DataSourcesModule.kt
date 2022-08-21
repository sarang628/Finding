package com.sarang.torang.di

import android.content.Context
import com.example.torang_core.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {
    @Binds
    abstract fun provideLocalDataSource(myReviewsLocalDataSourceImpl: MyReviewsLocalDataSourceImpl): MyReviewsLocalDataSource

    @Binds
    abstract fun provideRemoteDataSource(myReviewsRemoteDataSourceImpl: MyReviewsRemoteDataSourceImpl): MyReviewsRemoteDataSource
}*/


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule1 {
    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }
}