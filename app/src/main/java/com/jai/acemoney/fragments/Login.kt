package com.jai.acemoney.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.jai.acemoney.R
import com.jai.acemoney.data.UserViewModel
import java.nio.file.Paths.get

class login : Fragment() {
    lateinit var reg : TextView
    lateinit var login: Button
    lateinit var loginuser:EditText
    lateinit var loginpassword:EditText
    lateinit var  mUserViewModel: UserViewModel

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        navController = findNavController()
        reg = view.findViewById<TextView>(R.id.registerlogin)
        login=view.findViewById(R.id.login_btn)
        loginuser= view.findViewById(R.id.login_user)
        loginpassword=view.findViewById(R.id.login_password)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        reg.setOnClickListener {
            view.findNavController().navigate(R.id.action_login_to_register)

        }
        login.setOnClickListener {
            val username= loginuser.text.toString().trim()
            val password= loginpassword.text.toString().trim()
            mUserViewModel.verifyUser(username)
            mUserViewModel.verifyPassword.observe(viewLifecycleOwner, Observer {
                if (it!=null && it.equals(password)){
                    Toast.makeText(requireContext(),"Login Successfull.",Toast.LENGTH_SHORT).show()
                    val action = loginDirections.actionLoginToHome2()
                    navController.navigate(action)

                }else{
                    Toast.makeText(requireContext(),"Password incorrect",Toast.LENGTH_SHORT).show()
                }
            })

        }


return view
    }

//    private fun logincheck(username: String, password: String): Boolean {
//        return !(TextUtils.isEmpty(username)&&TextUtils.isEmpty(password)) }

}
