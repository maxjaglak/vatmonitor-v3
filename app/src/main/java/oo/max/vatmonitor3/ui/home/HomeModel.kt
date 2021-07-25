package oo.max.vatmonitor3.ui.home

import dagger.hilt.android.scopes.ViewModelScoped
import io.reactivex.Single
import oo.max.vatmonitor3.bl.nip.NipDataRepository
import oo.max.vatmonitor3.bl.nip.VatVerificationService
import javax.inject.Inject

@ViewModelScoped
class HomeModel @Inject constructor(
    private val nipDataRepository: NipDataRepository,
    private val vatVerificationService: VatVerificationService,
) {

    fun checkNipStatus(nip: String) = Single.create<NipStatusData> { emitter ->
        try {
            val nipData = nipDataRepository.getNipDataForToday(nip)
            val isValid = vatVerificationService.hasActiveVatStatus(nipData)
            emitter.onSuccess(NipStatusData(isValid))
        } catch(e: Exception) {
            emitter.tryOnError(e)
        }
    }

}