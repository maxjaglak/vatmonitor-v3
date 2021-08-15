package oo.max.vatmonitor3.ui.home

import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Single
import oo.max.vatmonitor3.bl.history.HistoryService
import oo.max.vatmonitor3.bl.nip.NipDataRepository
import oo.max.vatmonitor3.bl.nip.VatVerificationService
import javax.inject.Inject

@ViewModelScoped
class HomeModel @Inject constructor(
    private val nipDataRepository: NipDataRepository,
    private val vatVerificationService: VatVerificationService,
    private val historyService: HistoryService,
) {

    fun checkNipStatus(nip: String) = Single.create<NipStatusData> { emitter ->
        try {
            val nipData = nipDataRepository.getNipDataForToday(nip)
            val isValid = vatVerificationService.hasActiveVatStatus(nipData)
            historyService.saveCheckToHistory(nip, isValid)
            emitter.onSuccess(NipStatusData(isValid))
        } catch (e: Exception) {
            emitter.tryOnError(e)
            historyService.saveCheckToHistory(nip, result = false, error = true)
        }
    }

}