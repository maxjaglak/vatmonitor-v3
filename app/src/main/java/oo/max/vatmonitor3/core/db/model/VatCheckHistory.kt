package oo.max.vatmonitor3.core.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VatCheckHistory(
    @PrimaryKey var id: Long?,
    @ColumnInfo var nipNumber: String?,
    @ColumnInfo var checkTimestamp: Long?,
    @ColumnInfo var checkResult: Boolean?,
)