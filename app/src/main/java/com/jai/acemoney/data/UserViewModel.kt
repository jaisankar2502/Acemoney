package com.jai.acemoney.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) :AndroidViewModel(application) {
    private var readAllData:LiveData<List<User>>
    private var repository:UserRepository
    var verifyPassword = MutableLiveData<String>()
    var passWord : String? =null
    init {
        val userDao= Userdatabase.getDatabase(application).userdao()
        repository= UserRepository(userDao)
        readAllData=repository.readAllData
    }
    fun adduser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
    fun verifyUser(name:String):String?{
       viewModelScope.launch (Dispatchers.IO){
           verifyPassword.postValue(repository.loginUser(name))
        }
        return passWord

    }

}
