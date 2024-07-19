package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.data.network.ApiClient
import ar.edu.unlam.mobile.scaffolding.data.network.CountryApiService
import ar.edu.unlam.mobile.scaffolding.data.network.RankingApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Named("country")
    @Singleton
    fun provideRetrofit(): Retrofit = ApiClient.retrofit

    @Provides
    @Singleton
    fun provideCountryApiService(
        @Named("country") retrofit: Retrofit,
    ): CountryApiService = retrofit.create(CountryApiService::class.java)

    @Provides
    @Named("ranking")
    @Singleton
    fun provideRetrofitSheet(): Retrofit = ApiClient.retrofitSheet

    @Provides
    @Singleton
    fun provideRankineApiService(
        @Named("ranking") retrofit: Retrofit,
    ): RankingApiService = retrofit.create(RankingApiService::class.java)
}
