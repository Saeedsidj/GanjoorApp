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
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieAdApi(): PoetsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
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
