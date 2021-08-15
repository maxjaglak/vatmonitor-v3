package oo.max.vatmonitor3.core.di

import android.app.Activity
import android.content.Context
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import oo.max.vatmonitor3.R
import oo.max.vatmonitor3.bl.nip.*
import oo.max.vatmonitor3.core.apifactory.AppApiClientFactory
import oo.max.vatmonitor3.core.db.AppDatabase
import oo.max.vatmonitor3.core.db.dao.VatNumberDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonProvideModule {

    @Provides
    @Singleton
    fun providerMFApiClient(apiClientFactory: AppApiClientFactory): MFApiClient =
        apiClientFactory.createApiClient(MFApiClient::class.java)

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "oo.max.vatmonitorv3.db").build()

    @Provides
    @Singleton
    fun provideVatNumberDao(appDatabase: AppDatabase) = appDatabase.vatNumberDao()

    @Provides
    @Singleton
    fun providerVatCheckHistoryDao(appDatabase: AppDatabase) = appDatabase.vatCheckHistoryDao()

}