package oo.max.vatmonitor3.ui.home

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class HomeModel @Inject constructor() {
    fun getLabel(): String? {
        return "This is home Fragment - text from model"
    }
}