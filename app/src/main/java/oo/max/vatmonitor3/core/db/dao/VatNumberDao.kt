package oo.max.vatmonitor3.core.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import oo.max.vatmonitor3.core.db.model.NipNumber

@Dao
interface VatNumberDao {

    @Query("SELECT * FROM NipNumber")
    fun getAll(): List<NipNumber>

    @Query("SELECT * FROM NipNumber WHERE nipNumber = :nipNumberInput")
    fun getByVatNumber(nipNumberInput: String): NipNumber?

    @Insert
    fun insert(nipNumber: NipNumber)

    @Update
    fun update(nipNumber: NipNumber)

}