package com.jai.acemoney.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User) {
        userDao.adduser(user)
    }
    suspend fun loginUser(name:String) : String? = userDao.verifyUser(name)
//    fun verifyUser(name:String,password:String) {
//        userDao.verifyUser(name, password)
//    }
}