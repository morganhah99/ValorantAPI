package com.example.valorantapi.di

import com.example.valorantapi.data.api.ApiDetails
import com.example.valorantapi.data.api.ApiEndpoints
import com.example.valorantapi.data.repository.ApiRepository
import com.example.valorantapi.data.repository.ApiRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Named("ValorantRetrofit")
    fun provideValorantRetrofit(): Retrofit {
        val gson = Gson()
        val gsonConverterFactory = GsonConverterFactory.create(gson)

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Named("GitHubRetrofit")
    fun provideGitHubRetrofit(): Retrofit {
        val gson = Gson()
        val gsonConverterFactory = GsonConverterFactory.create(gson)

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(ApiDetails.GITHUB_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Named("ValorantApiEndpoints")
    fun provideValorantApiEndpoints(@Named("ValorantRetrofit") retrofit: Retrofit): ApiEndpoints {
        return retrofit.create(ApiEndpoints::class.java)
    }

    @Provides
    @Named("GitHubApiEndpoints")
    fun provideGitHubApiEndpoints(@Named("GitHubRetrofit") retrofit: Retrofit): ApiEndpoints {
        return retrofit.create(ApiEndpoints::class.java)
    }

    @Provides
    @Named("ValorantRepository")
    fun provideValorantRepository(@Named("ValorantApiEndpoints") apiEndpoints: ApiEndpoints): ApiRepository {
        return ApiRepositoryImpl(apiEndpoints)
    }

    @Provides
    @Named("GitHubRepository")
    fun provideGitHubRepository(@Named("GitHubApiEndpoints") apiEndpoints: ApiEndpoints): ApiRepository {
        return ApiRepositoryImpl(apiEndpoints)
    }
}
