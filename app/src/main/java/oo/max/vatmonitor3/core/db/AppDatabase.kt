package oo.max.vatmonitor3.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import oo.max.vatmonitor3.core.db.dao.VatCheckHistoryDao
import oo.max.vatmonitor3.core.db.dao.VatNumberDao
import oo.max.vatmonitor3.core.db.model.VatCheckHistory
import oo.max.vatmonitor3.core.db.model.NipNumber

@Database(entities = arrayOf(
    NipNumber::class,
    VatCheckHistory::class
), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun vatNumberDao(): VatNumberDao
    abstract fun vatCheckHistoryDao(): VatCheckHistoryDao
}