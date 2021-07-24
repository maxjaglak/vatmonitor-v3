package oo.max.vatmonitor3.core.di

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import oo.max.vatmonitor3.R

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

//    @Provides
//    fun provideNavController(activity: Activity): NavController {
//        return activity.findNavController(R.id.nav_host_fragment_activity_main)
//    }

}