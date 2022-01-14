package com.jai.acemoney.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict =OnConflictStrategy.IGNORE)
    suspend fun adduser(user: User)
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>
   @Query("SELECT password FROM user_table WHERE username =:name")
    suspend fun verifyUser(name:String) : String?

}