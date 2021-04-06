package io.aaronspooky.network

import dagger.Module
import dagger.Provides
import dagger.hilt.DefineComponent
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import io.aaronspooky.network.data.NetworkRemoteDataSource
import io.aaronspooky.network.data.NetworkRepositoryImpl
import io.aaronspooky.network.data.remote.ApiSource
import io.aaronspooky.network.data.remote.NetworkRemoteDataSourceImpl
import io.aaronspooky.network.domain.NetworkRepository
import io.aaronspooky.network.domain.usecase.FetchPostsUseCase
import io.aaronspooky.network.internet_connection.RetrofitBuilder
import retrofit2.Retrofit
import javax.inject.Singleton

@DefineComponent(parent = SingletonComponent::class)
class NetworkModule {

    /** USE CASE **/
    @Provides
    @ActivityRetainedScoped
    fun provideFetchPostsUseCase(repository: NetworkRepository): FetchPostsUseCase =
        FetchPostsUseCase(repository = repository)

    /** REPOSITORY **/
    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: NetworkRemoteDataSource): NetworkRepository =
        NetworkRepositoryImpl(remoteDataSource = remoteDataSource)

    /** DATA SOURCE **/
    @Provides
    @Singleton
    fun provideRemoteDataSource(apiSource: ApiSource): NetworkRemoteDataSource =
        NetworkRemoteDataSourceImpl(apiSource = apiSource)

    /** API SERVICE **/
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiSource =
        retrofit.create(ApiSource::class.java)

    /** RETROFIT INSTANCE **/
    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String = "https://jsonplaceholder.typicode.com/todos/1"): Retrofit =
        RetrofitBuilder(baseUrl = baseUrl).build()
}