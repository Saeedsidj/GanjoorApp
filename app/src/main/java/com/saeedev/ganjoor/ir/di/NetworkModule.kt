package com.saeedev.ganjoor.ir.di

import com.saeedev.ganjoor.ir.data.local.dataSource.LocalDataSource
import com.saeedev.ganjoor.ir.data.local.dataSource.LocalDataSourceImpl
import com.saeedev.ganjoor.ir.data.network.dataSource.NetworkDataSource
import com.saeedev.ganjoor.ir.data.network.dataSource.NetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetWorkModule {

    @Binds
    @Singleton
    abstract fun bindNetWorkDataSource(
        impl: NetworkDataSourceImpl
    ): NetworkDataSource

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(
        impl: LocalDataSourceImpl
    ): LocalDataSource

}
