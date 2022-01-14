package com.jai.acemoney.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jai.acemoney.R
import com.jai.acemoney.data.User
import com.jai.acemoney.data.UserViewModel


class Register : Fragment() {
    lateinit var register:Button
    lateinit var  mUserViewModel: UserViewModel
    lateinit var name:EditText
    lateinit var uname:EditText
    lateinit var password:EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_register, container, false)
        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        register=view.findViewById(R.id.register_btn)
        name=view.findViewById(R.id.reg_user)
        uname=view.findViewById(R.id.reg_username)
        password=view.findViewById(R.id.reg_password)
        register.setOnClickListener {
            insertdataTodatabase()
        }
        return view

    }

    private fun insertdataTodatabase() {
        var name1=name.text.toString()
        var uname1=uname.text.toString()
        var password1=password.text.toString()
        if (inputcheck(name1,uname1,password1)){
            val user=User(0,name1,uname1,password1)
            mUserViewModel.adduser(user)
            Toast.makeText(requireContext(),"Register successfully!",Toast.LENGTH_SHORT).show()
            // navigate back to login page
            findNavController().navigateUp()

        }
        else{
            Toast.makeText(requireContext(),"Please fill out all fields. ",Toast.LENGTH_SHORT).show()
        }




    }
private fun inputcheck(name1:String,uname1:String,password1:String):Boolean{
    return !(TextUtils.isEmpty(name1)&& TextUtils.isEmpty(uname1)&&TextUtils.isEmpty(password1))

}

}