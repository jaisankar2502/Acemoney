package com.jai.acemoney.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User (
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo(name="Name")val name:String,
    @ColumnInfo(name="Username")val username:String,
    @ColumnInfo(name="Password")val password: String
    )
