package oo.max.vatmonitor3.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import oo.max.vatmonitor3.bl.DatePrinterService
import oo.max.vatmonitor3.core.db.model.NipNumber
import oo.max.vatmonitor3.core.rx.ioMain
import oo.max.vatmonitor3.core.rx.store
import oo.max.vatmonitor3.ui.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val model: HistoryModel,
    private val datePrinterService: DatePrinterService,
) : BaseViewModel() {

    private val listOfNipNumbersMutable = MutableLiveData<List<NipNumberDisplay>>().apply {
        value = listOf()
    }
    val listOfNipNumbers: LiveData<List<NipNumberDisplay>> = listOfNipNumbersMutable

    fun viewLoaded() {
        reload()
    }

    private fun reload() {
        progressMutable.value = true

        model.getNipNumbers()
            .ioMain()
            .subscribe({ data ->
                progressMutable.value = false
                listOfNipNumbersMutable.value = mapDataForDisplay(data)
            }, { e ->
                dispatchThrowable(e)
                progressMutable.value = false

            })
            .store(this)
    }

    private fun mapDataForDisplay(data: List<NipNumber>?): List<NipNumberDisplay> {
        return data?.map { NipNumberDisplay(
            number = it.nipNumber ?: "",
            createdDatePrinted = datePrinterService.printDate(it.creationTimestamp?: 0L)
        )}?.toList() ?: listOf()
    }

}

data class NipNumberDisplay(
    val number: String,
    val createdDatePrinted: String,
)