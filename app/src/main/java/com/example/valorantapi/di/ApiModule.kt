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

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    fun providesLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun providesGsonConverterFactory(
        gson:Gson
    ) = GsonConverterFactory.create()

    @Provides
    fun providesOkHttpClient(
        logging:HttpLoggingInterceptor
    ):OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()

    @Provides
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory:GsonConverterFactory
    ):Retrofit = Retrofit.Builder()
        .baseUrl(ApiDetails.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    fun apiInstance(retrofit: Retrofit):ApiEndpoints = retrofit.create(ApiEndpoints::class.java)

    @Provides
    fun providesRepository(apiEndpoints: ApiEndpoints):ApiRepository{
        return ApiRepositoryImpl(apiEndpoints)
    }
}