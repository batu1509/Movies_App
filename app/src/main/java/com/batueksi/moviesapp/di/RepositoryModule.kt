package com.batueksi.moviesapp.di


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.batueksi.moviesapp.data.repository.DataOperationsImpl
import com.batueksi.moviesapp.domain.repository.DataStoreOperations
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        dataStore: DataStore<Preferences>
    ): DataStoreOperations {
        return DataOperationsImpl(dataStore = dataStore)
    }


}