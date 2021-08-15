package oo.max.vatmonitor3.ui.history

import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Single
import oo.max.vatmonitor3.bl.history.HistoryService
import oo.max.vatmonitor3.core.db.model.NipNumber
import javax.inject.Inject

@ViewModelScoped
class HistoryModel @Inject constructor(
    private val historyService: HistoryService,
){
    fun getNipNumbers() = Single.create<List<NipNumber>> { emitter ->
        try {
            val nips = historyService.getVatNumbers()
            emitter.onSuccess(nips)
        } catch (e: Exception) {
            emitter.tryOnError(e)
        }
    }

}