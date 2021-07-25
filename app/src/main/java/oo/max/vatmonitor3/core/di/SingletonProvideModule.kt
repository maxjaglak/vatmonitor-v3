package oo.max.vatmonitor3.core.di

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import oo.max.vatmonitor3.R
import oo.max.vatmonitor3.bl.nip.*
import oo.max.vatmonitor3.core.apifactory.AppApiClientFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonProvideModule {

    @Provides
    @Singleton
    fun providerMFApiClient(apiClientFactory: AppApiClientFactory): MFApiClient =
        apiClientFactory.createApiClient(MFApiClient::class.java)

}