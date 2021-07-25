package oo.max.vatmonitor3.bl.nip

import oo.max.vatmonitor3.bl.nip.model.NipData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VatVerificationServiceImpl @Inject constructor() : VatVerificationService {

    override fun hasActiveVatStatus(nipData: NipData): Boolean {
        return "Czynny" == nipData.statusVat
    }
}

interface VatVerificationService {
    fun hasActiveVatStatus(nipData: NipData): Boolean
}