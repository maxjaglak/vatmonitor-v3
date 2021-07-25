package oo.max.vatmonitor3.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import oo.max.vatmonitor3.core.rx.ioMain
import oo.max.vatmonitor3.core.rx.store
import oo.max.vatmonitor3.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val model: HomeModel
) : BaseViewModel() {

    val nipStatusInternal = MutableLiveData<NipStatusData?>().apply {
        value = null
    }
    val nipStatus: LiveData<NipStatusData?> = nipStatusInternal

    fun checkButtonClicked(nip: String) {
        progressMutable.value = true

        model.checkNipStatus(nip)
            .ioMain()
            .subscribe({ data ->
                progressMutable.value = false
                nipStatusInternal.value = data
            }, { t ->
                progressMutable.value = false
                nipStatusInternal.value = null
                dispatchThrowable(t)
            })
            .store(this)
    }
}

data class NipStatusData(
    val isValidVatPayer: Boolean
)
