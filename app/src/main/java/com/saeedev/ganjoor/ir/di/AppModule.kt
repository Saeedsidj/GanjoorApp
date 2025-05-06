package com.saeedev.ganjoor.ir.di

import android.content.Context
import androidx.room.Room
import com.saeedev.ganjoor.ir.common.Constants
import com.saeedev.ganjoor.ir.data.local.AppDataBase
import com.saeedev.ganjoor.ir.data.local.dataSource.LocalDataSource
import com.saeedev.ganjoor.ir.data.network.PoetsApi
import com.saeedev.ganjoor.ir.data.network.dataSource.NetworkDataSource
import com.saeedev.ganjoor.ir.data.repository.PoetRepositoryImpl
import com.saeedev.ganjoor.ir.domain.repository.PoetRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieAdApi(
        okHttpClient: OkHttpClient
    ): PoetsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PoetsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "ganjoor")
            .build()
    }

    @Provides
    @Singleton
    fun providePoetRepository(api: NetworkDataSource, db: LocalDataSource): PoetRepository {
        return PoetRepositoryImpl(api, db)
    }

}
