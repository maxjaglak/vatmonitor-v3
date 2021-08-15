package oo.max.vatmonitor3.bl.history

import oo.max.vatmonitor3.core.db.dao.VatCheckHistoryDao
import oo.max.vatmonitor3.core.db.dao.VatNumberDao
import oo.max.vatmonitor3.core.db.model.VatCheckHistory
import oo.max.vatmonitor3.core.db.model.NipNumber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HistoryService @Inject constructor(
    private val vatNumberDao: VatNumberDao,
    private val vatCheckHistoryDao: VatCheckHistoryDao,
) {

    fun saveCheckToHistory(vat: String, result: Boolean, error: Boolean = false) {
        val existingVatNumber = vatNumberDao.getByVatNumber(vat)

        if (existingVatNumber == null) {
            createVatNumber(vat)
        }

        createVatNumberCheck(vat, result)
    }

    private fun createVatNumber(vat: String) {
        val vatNumber = NipNumber(
            vat,
            System.currentTimeMillis()
        )
        vatNumberDao.insert(vatNumber)
    }

    private fun createVatNumberCheck(vat: String, result: Boolean) {
        val vatNumberCheck = VatCheckHistory(
            null,
            vat,
            System.currentTimeMillis(),
            result
        )
        vatCheckHistoryDao.insert(vatNumberCheck)
    }

    fun getVatNumbers() = vatNumberDao.getAll()

    fun getVatCheckHistoryByVatNumber(vatNumber: String) =
        vatCheckHistoryDao.getCheckHistoryForNumber(vatNumber)

}