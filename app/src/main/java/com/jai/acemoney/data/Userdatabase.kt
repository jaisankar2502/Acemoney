package com.jai.acemoney.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database( entities = [User::class], version = 1, exportSchema = false)
abstract class Userdatabase :RoomDatabase() {
    abstract  fun userdao():UserDao
    companion object {
        @Volatile()
        private var INSTANCE: Userdatabase? = null
        fun getDatabase(context: Context): Userdatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val intance = Room.databaseBuilder(
                    context.applicationContext,
                    Userdatabase::class.java,
                    "User_databe"
                ).build()
                INSTANCE = intance
                return intance
            }
        }
    }
}