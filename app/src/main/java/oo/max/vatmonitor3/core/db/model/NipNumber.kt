package oo.max.vatmonitor3.core.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NipNumber(
    @PrimaryKey var nipNumber: String,
    @ColumnInfo var creationTimestamp: Long?
)