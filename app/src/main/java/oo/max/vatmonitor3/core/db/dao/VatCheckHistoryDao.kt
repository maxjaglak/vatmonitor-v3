package oo.max.vatmonitor3.core.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import oo.max.vatmonitor3.core.db.model.VatCheckHistory

@Dao
interface VatCheckHistoryDao {

    @Query("SELECT * FROM VatCheckHistory WHERE nipNumber = :nipNumberInput ORDER BY checkTimestamp DESC")
    fun getCheckHistoryForNumber(nipNumberInput: String): List<VatCheckHistory>

    @Query("SELECT * FROM VatCheckHistory WHERE id = :id")
    fun getById(id: Long): VatCheckHistory

    @Insert
    fun insert(vatCheckHistory: VatCheckHistory)

    @Update
    fun update(vatCheckHistory: VatCheckHistory)

}