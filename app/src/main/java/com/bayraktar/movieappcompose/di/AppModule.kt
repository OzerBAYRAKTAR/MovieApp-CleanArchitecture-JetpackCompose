package com.bayraktar.movieappcompose.di

import com.bayraktar.movieappcompose.data.remote.ApiService
import com.bayraktar.movieappcompose.data.repository.MovieRepositoryImpl
import com.bayraktar.movieappcompose.domain.repository.MovieRepository
import com.bayraktar.movieappcompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideMovieApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(ApiService::class.java)
    }
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val intercepter= HttpLoggingInterceptor()
        intercepter.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .readTimeout(300, TimeUnit.SECONDS)
            .connectTimeout(300, TimeUnit.SECONDS)
            .addInterceptor(intercepter)
            .build()
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ApiService): MovieRepository{
        return MovieRepositoryImpl(apiService)
    }
}