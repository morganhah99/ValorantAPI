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
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Named("ValorantRetrofit")
    @Singleton
    fun provideValorantRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Named("GitHubRetrofit")
    @Singleton
    fun provideGitHubRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
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
